package com.learning.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@EnableTransactionManagement
@ComponentScan(basePackages = { 
		"com.learning.spring"
		})
@PropertySource(value = { "classpath:application.properties" })
public class Initializer {
 
}
