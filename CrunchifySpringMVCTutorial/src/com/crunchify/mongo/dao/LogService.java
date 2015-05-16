package com.crunchify.mongo.dao;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

/**
 * Used for logging data.
 * 
 * @author pascal
 */
@Service
public interface LogService<T> {

	public ObjectId add(T log);

	public T get(ObjectId id);

}