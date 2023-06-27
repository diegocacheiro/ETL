package org.example.service;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.example.domain.Measure;
import org.example.domain.json.Acceletarions;
import org.example.domain.json.Bumps;
import org.example.domain.json.Locations;
import org.example.domain.json.Travel;
import org.example.domain.json.TravelDatos;
import org.example.entity.TrackPoint;
import org.example.entity.TrackPointPK;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class RemoteDataService {

	@Autowired
	private TrackPointService trackPointService;

	private static final String URLlistaTraza = "https://menuaffinity.es/citius/webapi/api/travels";
	private static final String URLTraza = "https://menuaffinity.es/citius/webapi/api/download/exportdata/";
	private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiam9zdGFiIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjpbIlVzZXIiLCJBZG1pbmlzdHJhdG9yIl19.2RlhK-yeeMWETzMLm7_ACsZHRvfY10deMVEUKgzBu3I";

	public Integer ultimaTraza() {
		List<String> t = trackPointService.tracks();
		List<Integer> id = new ArrayList();
		for (int i = 0; i < t.size(); i++) {
			id.add(Integer.parseInt(t.get(i).split("-")[1]));
		}
		return Collections.max(id);
	}

	public void getDataFromRemote() throws UnirestException {
		Unirest.setTimeouts(0, 0);
		// Sacamos la lista de trazas existentes
		HttpResponse<String> response = Unirest.get(URLlistaTraza).header("authorization", "bearer " + TOKEN)
				.asString();
		String json = response.getBody();

		// Lo convertimos en un objeto y creamos una lista de objetos
		Type listType = new TypeToken<List<Travel>>() {
		}.getType();
		List<Travel> travels = new Gson().fromJson(json, listType);

		Type t = new TypeToken<List<TravelDatos>>() {
		}.getType();
			
		Integer ultimatraza =  ultimaTraza();
		//System.out.println(ultimatraza);
		// Recorremos cada objeto y usamos el id para acceder a la traza
		for (Iterator<Travel> iterator = travels.iterator(); iterator.hasNext();) {
			Travel travel = (Travel) iterator.next();
			//System.out.println(travel.getId());
			if (travel.getId() > 29 && ultimatraza < travel.getId()) {
				// accedemos a la traza y guardamos su json
				response = Unirest.get(URLTraza + travel.getId()).header("authorization", "bearer " + TOKEN).asString();
				json = response.getBody();
				List<TravelDatos> travelsCompleto = new Gson().fromJson(json, t);

				List<Acceletarions> acceletarions = travelsCompleto.get(0).getAcceletarions();
				List<Locations> locations = travelsCompleto.get(0).getLocations();
				List<Bumps> bumps = travelsCompleto.get(0).getBumps();
				List<TrackPoint> tp = new ArrayList<>();
				if (acceletarions != null && locations != null && locations.size()>1){
					// Para cada localización
					for (int i = 0; i < locations.size(); i++) {
						List<Measure> measures = new ArrayList<>();
						// Vemos si localización, esta en la primera localización o está en la última
						if (i == 0) {
							// Recorremos las aceleraciones
							for (int j = 0; j < acceletarions.size(); j++) {
								// Si la aceleracion está correspondida en el rango de la localización y
								// localización + 1 o es menor que la localización, lo agregamos
								if (Long.parseLong(acceletarions.get(j).getTime()) >= Long
										.parseLong(locations.get(i).getTime())
										&& Long.parseLong(acceletarions.get(j).getTime()) <= Long
												.parseLong(locations.get(i + 1).getTime())
										|| Long.parseLong(acceletarions.get(j).getTime()) <= Long
												.parseLong(locations.get(i).getTime())) {
									measures.add(new Measure(new Timestamp(Long.parseLong(acceletarions.get(j).getTime())),
											acceletarions.get(j).getZ(), 0));
								}
							}
	
							Geometry point = new GeometryFactory().createPoint(
									new Coordinate(locations.get(i).getLongitude(), locations.get(i).getLatitude()));
							point.setSRID(4326);
							tp.add(new TrackPoint(
									new TrackPointPK(
											travelsCompleto.get(0).getCar().getBrand() + "_"
													+ travelsCompleto.get(0).getCar().getModel() + "_"
													+ travelsCompleto.get(0).getCar().getYear() + "-"
													+ Integer.toString(locations.get(i).getTravelId()),
											locations.get(i).getId()),
									point, locations.get(i).getSpeed(), locations.get(i).getAltitude(),
									new Timestamp(Long.parseLong(locations.get(i).getTime())),
									new Timestamp(Long.parseLong(locations.get(i + 1).getTime())), measures));
	
						} else if (i < locations.size() - 1 && i != 0) {
							// Recorremos las aceleraciones
							for (int j = 0; j < acceletarions.size(); j++) {
								// Si la aceleracion está correspondida en el rango de la localización y
								// localización + 1, lo agregamos
								if (Long.parseLong(acceletarions.get(j).getTime()) >= Long
										.parseLong(locations.get(i).getTime())
										&& Long.parseLong(acceletarions.get(j).getTime()) <= Long
												.parseLong(locations.get(i + 1).getTime())) {
									measures.add(new Measure(new Timestamp(Long.parseLong(acceletarions.get(j).getTime())),
											acceletarions.get(j).getZ(), 0));
								}
							}
							Geometry point = new GeometryFactory().createPoint(
									new Coordinate(locations.get(i).getLongitude(), locations.get(i).getLatitude()));
							point.setSRID(4326);
							tp.add(new TrackPoint(
									new TrackPointPK(
											travelsCompleto.get(0).getCar().getBrand() + "_"
													+ travelsCompleto.get(0).getCar().getModel() + "_"
													+ travelsCompleto.get(0).getCar().getYear() + "-"
													+ Integer.toString(locations.get(i).getTravelId()),
											locations.get(i).getId()),
									point, locations.get(i).getSpeed(), locations.get(i).getAltitude(),
									new Timestamp(Long.parseLong(locations.get(i).getTime())),
									new Timestamp(Long.parseLong(locations.get(i + 1).getTime())), measures));
	
						} else {
							// Recorremos las aceleraciones
							for (int j = 0; j < acceletarions.size(); j++) {
								// Si la aceleracion está correspondida en el rango de la localización, lo
								// agregamos
								if (Long.parseLong(acceletarions.get(j).getTime()) >= Long
										.parseLong(locations.get(i).getTime())) {
									measures.add(new Measure(new Timestamp(Long.parseLong(acceletarions.get(j).getTime())),
											acceletarions.get(j).getZ(), 0));
								}
							}
							Geometry point = new GeometryFactory().createPoint(
									new Coordinate(locations.get(i).getLongitude(), locations.get(i).getLatitude()));
							point.setSRID(4326);
							tp.add(new TrackPoint(
									new TrackPointPK(
											travelsCompleto.get(0).getCar().getBrand() + "_"
													+ travelsCompleto.get(0).getCar().getModel() + "_"
													+ travelsCompleto.get(0).getCar().getYear() + "-"
													+ Integer.toString(locations.get(i).getTravelId()),
											locations.get(i).getId()),
									point, locations.get(i).getSpeed(), locations.get(i).getAltitude(),
									new Timestamp(Long.parseLong(locations.get(i).getTime())),
									new Timestamp(Long.parseLong(acceletarions.get(acceletarions.size() - 1).getTime())),
									measures));
						}
					}
	
					// Leemos los baches del array bumps y ponemos a 1 aquellos que correspondan
					for (int i = 0; i < bumps.size(); i++) {
						for (int j = 0; j < tp.size(); j++) {
							if (new Timestamp(Long.parseLong(bumps.get(i).getTime())).equals(tp.get(j).getStartTime())) {
								Double maxVa = 0.0;
								Timestamp time = null;
								for (Measure measure : tp.get(j - 1).getMeasures()) {
									if (measure.getVa() > maxVa) {
										maxVa = measure.getVa();
										time = measure.getTime();
									}
								}
								for (Measure measure : tp.get(j - 1).getMeasures()) {
									if (measure.getTime().equals(time)) {
										measure.setBm(1);
									}
								}
							}
						}
					}
					for (int j = 0; j < tp.size(); j++) {
						try {
							trackPointService.save(tp.get(j));
							System.out.println(travel.getId() + " - Traza añadida");
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				} else {
					System.out.println(travel.getId() + " - Traza no válida");
				}
				
			} else {
				System.out.println(travel.getId() + " - Traza existente");
			}
		}
	}
}
