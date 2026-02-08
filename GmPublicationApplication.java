package com.example.GM.Publication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication

@EntityScan("com.example.GM.Publication.entity")
@EnableJpaRepositories("com.example.GM.Publication.repository")
public class GmPublicationApplication {

	public static void main(String[] args) {

		SpringApplication.run(GmPublicationApplication.class, args);
	}

}
