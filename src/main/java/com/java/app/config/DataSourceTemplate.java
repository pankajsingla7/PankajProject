package com.java.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSourceTemplate {
	
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public DataSourceTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
