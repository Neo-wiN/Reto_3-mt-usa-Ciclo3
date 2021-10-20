package com.boat;
/**
* 
* @author  Nestor Yara G
* @version 1.0
* @since   2021-10-20
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// habilita el mecanismo de configuración automática de Spring Boot
@SpringBootApplication 
public class BoatApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoatApplication.class, args);
	}

}
