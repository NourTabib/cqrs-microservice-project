package com.nourtabib.app.queryservice;

import com.nourtabib.app.queryservice.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class QueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryServiceApplication.class, args);
	}

}
