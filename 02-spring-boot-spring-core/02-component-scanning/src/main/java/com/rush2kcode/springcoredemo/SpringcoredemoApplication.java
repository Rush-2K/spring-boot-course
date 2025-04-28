package com.rush2kcode.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//list base packages to scan
// @SpringBootApplication(scanBasePackages = { "com.rush2kcode.springcoredemo",
// 		"com.rush2kcode.util" })

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
