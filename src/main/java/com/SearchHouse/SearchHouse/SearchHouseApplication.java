package com.searchhouse.searchhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
public class SearchHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchhouseApplication.class, args);
	}

}
