package com.swproject.supersale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperSaleApplication {

	public static final Logger log = LoggerFactory.getLogger(SuperSaleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SuperSaleApplication.class, args);
		log.info("Aplicacao iniciada com sucesso!...");
	}

}
