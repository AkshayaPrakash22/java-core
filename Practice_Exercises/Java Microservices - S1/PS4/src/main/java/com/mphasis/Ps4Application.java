package com.mphasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ps4Application {

	public static void main(String[] args) {
		SpringApplication.run(Ps4Application.class, args);
		System.out.println("Server Up!!!");
	}

}
