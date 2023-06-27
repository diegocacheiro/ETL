package org.example;

import org.example.service.RemoteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class GeoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GeoApplication.class, args);
	}

	@Autowired
	private RemoteDataService remoteDataService;

	@Override
	public void run(String... args) throws Exception {
		//long startTime = System.nanoTime();
		remoteDataService.getDataFromRemote();
		//long endTime = System.nanoTime() - startTime;
		//System.out.println("Tiempo:" + endTime/1e6/1000);
		System.out.println("ETL finalizada con éxito");
		
	}
	
	@Scheduled(initialDelay = 300000, fixedRate = 300000) // Ejecutar cada 5 segundos
    public void executeScheduledTask() {
        try {
            run();
            System.out.println("ETL finalizada con éxito");
        } catch (Exception e) {
            // Manejar cualquier excepción
            e.printStackTrace();
        }
    }
}
