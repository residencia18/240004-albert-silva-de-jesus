package com.swproject.tradein;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TradeInApplication {

	public static final Logger log = LoggerFactory.getLogger(TradeInApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TradeInApplication.class, args);
		log.info("Aplicacao iniciada com sucesso!...");
	}

}
