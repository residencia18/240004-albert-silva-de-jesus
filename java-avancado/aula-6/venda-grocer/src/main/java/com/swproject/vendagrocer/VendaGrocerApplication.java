package com.swproject.vendagrocer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VendaGrocerApplication {

	public static final Logger log = LoggerFactory.getLogger(VendaGrocerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VendaGrocerApplication.class, args);
		log.info("Aplicacao iniciada com sucesso!...");
	}

}
