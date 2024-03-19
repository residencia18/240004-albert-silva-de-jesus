package com.swproject.sellgenius;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SellGeniusApplication {

	public static final Logger log = LoggerFactory.getLogger(SellGeniusApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SellGeniusApplication.class, args);
		log.info("Aplicação iniciada com sucesso!");
	}

}
