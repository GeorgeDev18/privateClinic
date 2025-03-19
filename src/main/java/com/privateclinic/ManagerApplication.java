package com.privateclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "com.privateclinic")
public class ManagerApplication {



	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}

}
