package com.thiago_Souza.Feign_Docker_Kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignDockerKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignDockerKafkaApplication.class, args);
	}

}
