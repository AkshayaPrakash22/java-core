package com.learning.day5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.learning.day5") 
public class AppConfig {
	@Bean
	public Battery battery() {
		
		return null;
		
	}
	
	@Bean
	public Disc disc() {
		return null;
	}
    
}