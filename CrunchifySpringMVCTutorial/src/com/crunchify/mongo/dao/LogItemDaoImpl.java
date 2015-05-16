package com.crunchify.mongo.dao;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pascal
 */
@Repository
public class LogItemDaoImpl extends AbstractBaseDao implements BaseDao<LogItem> {

	public LogItem selectByPk(ObjectId id) {
		return (LogItem) mongoTemplate.findById(id, LogItem.class);
	}

	public ObjectId insert(LogItem log) {
		mongoTemplate.insert(log);
		return log.getId();
	}
}