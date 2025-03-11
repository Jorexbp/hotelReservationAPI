package com.hotelReservationAPI.hotelReservationAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.hotelReservationAPI.hotelReservationAPI")
@EntityScan("com.hotelReservationAPI.hotelReservationAPI.model")
@EnableJpaRepositories
public class HotelReservationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationApiApplication.class, args);
	}

}
