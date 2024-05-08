package com.learning.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoDBConfig {

	@Bean(name =  { "mongoDbFactory"})
	@Scope("singleton")
	public MongoDbFactory getMongoDbFactory() {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		return new SimpleMongoClientDbFactory(mongoClient, "PassengerDetails");
	}
	@Bean
	public MongoTemplate getMongoTemplate(@Autowired @Qualifier("mongoDbFactory") MongoDbFactory mongoDbFactory) {
		
		MongoTemplate mongoTemplate =new MongoTemplate(mongoDbFactory);
		return mongoTemplate;
	}
}
