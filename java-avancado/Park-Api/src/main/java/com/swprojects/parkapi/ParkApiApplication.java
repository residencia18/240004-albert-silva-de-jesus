package com.swprojects.parkapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.swprojects.parkapi.service.EmailService;

@SpringBootApplication
public class ParkApiApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ParkApiApplication.class, args);
	}

	// @Autowired
	// EmailService emailService;

	@Override
	public void run(String... args) throws Exception {

		// emailService.enviarPedidoDeConfirmacaoDeCadastro("no.reply.smttsaj@gmail.com", "123456");
	}

}
