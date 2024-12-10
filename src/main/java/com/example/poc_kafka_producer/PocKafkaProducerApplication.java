package com.example.poc_kafka_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PocKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocKafkaProducerApplication.class, args);
	}

}
