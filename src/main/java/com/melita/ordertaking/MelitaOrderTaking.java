package com.melita.ordertaking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class MelitaOrderTaking {

	public static void main(String[] args) {
		SpringApplication.run(MelitaOrderTaking.class, args);
	}
}
