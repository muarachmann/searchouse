package com.SearchHouse.SearchHouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SearchHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchHouseApplication.class, args);
	}

}
