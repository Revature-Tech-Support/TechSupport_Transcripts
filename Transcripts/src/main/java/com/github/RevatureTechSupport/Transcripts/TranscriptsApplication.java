package com.github.RevatureTechSupport.Transcripts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableReactiveCassandraRepositories
@EnableWebFlux
public class TranscriptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranscriptsApplication.class, args);
	}

}
