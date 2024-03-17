package com.medicare.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MedicareCartServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MedicareCartServiceApplication.class, args);
	}

}
