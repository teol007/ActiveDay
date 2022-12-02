package com.ActiveDay.ris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication()
@CrossOrigin
public class RisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RisApplication.class, args);
	}

}
