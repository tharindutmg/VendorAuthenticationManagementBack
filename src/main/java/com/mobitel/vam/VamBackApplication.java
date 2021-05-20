package com.mobitel.vam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@EnableJpaAuditing
public class VamBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(VamBackApplication.class, args);
	}

}
