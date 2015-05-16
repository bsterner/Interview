package com.crunchify.mongo.dao;

import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Base DAO for Hibernate Entities
 * 
 * @author pascal
 */
public abstract class AbstractBaseDao {

	protected MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate template) {
		this.mongoTemplate = template;
	}

	public MongoTemplate getMongoTemplate() {
		return this.mongoTemplate;
	}

}