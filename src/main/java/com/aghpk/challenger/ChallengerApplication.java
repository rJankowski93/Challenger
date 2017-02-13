package com.aghpk.challenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ChallengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengerApplication.class, args);
	}
}
