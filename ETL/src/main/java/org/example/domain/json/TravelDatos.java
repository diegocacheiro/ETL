package org.example.domain.json;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class TravelDatos {
    @SerializedName("Id")
    @Expose
    private Integer Id;
    @SerializedName("RoadQuality")
    @Expose
    private String RoadQuality;
    @SerializedName("Date")
    @Expose
    private String Date;
    @SerializedName("RoadType")
    @Expose
    private Boolean RoadType;
    @SerializedName("BumpType")
    @Expose
    private Boolean BumpType;
    @SerializedName("CarId")
    @Expose
    private Integer CarId;
    @SerializedName("Car")
    @Expose
    private CarDatos Car;
    @SerializedName("Acceletarions")
    @Expose
    private List<Acceletarions> Acceletarions;
    @SerializedName("Locations")
    @Expose
    private List<Locations> Locations;
    @SerializedName("Bumps")
    @Expose
    private List<Bumps> Bumps;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getRoadQuality() {
		return RoadQuality;
	}
	public void setRoadQuality(String roadQuality) {
		RoadQuality = roadQuality;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Boolean getRoadType() {
		return RoadType;
	}
	public void setRoadType(Boolean roadType) {
		RoadType = roadType;
	}
	public Boolean getBumpType() {
		return BumpType;
	}
	public void setBumpType(Boolean bumpType) {
		BumpType = bumpType;
	}
	public Integer getCarId() {
		return CarId;
	}
	public void setCarId(Integer carId) {
		CarId = carId;
	}
	public CarDatos getCar() {
		return Car;
	}
	public void setCar(CarDatos car) {
		Car = car;
	}
	public List<Acceletarions> getAcceletarions() {
		return Acceletarions;
	}
	public void setAcceletarions(List<Acceletarions> acceletarions) {
		Acceletarions = acceletarions;
	}
	public List<Locations> getLocations() {
		return Locations;
	}
	public void setLocations(List<Locations> locations) {
		Locations = locations;
	}
	public List<Bumps> getBumps() {
		return Bumps;
	}
	public void setBumps(List<Bumps> bumps) {
		Bumps = bumps;
	}
	@Override
	public String toString() {
		return "TravelDatos [Id=" + Id + ", RoadQuality=" + RoadQuality + ", Date=" + Date + ", RoadType=" + RoadType
				+ ", BumpType=" + BumpType + ", CarId=" + CarId + ", Car=" + Car + ", Acceletarions=" + Acceletarions
				+ ", Locations=" + Locations + ", Bumps=" + Bumps + "]";
	}
    
    
}
