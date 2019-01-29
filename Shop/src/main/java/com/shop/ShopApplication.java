package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories

@SpringBootApplication
public class ShopApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		// TODO Auto-generated method stub

	}

}
