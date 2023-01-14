package com.nourtabib.app.commandservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class CommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandServiceApplication.class, args);
	}

}
