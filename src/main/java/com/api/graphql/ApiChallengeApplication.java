package com.api.graphql;

import com.api.graphql.entity.User;
import com.api.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiChallengeApplication.class, args);
	}

}
