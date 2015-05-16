package com.crunchify.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crunchify.mongo.dao.LogItem;
import com.crunchify.mongo.dao.LogService;
import com.crunchify.mongo.dao.MongoDBLoggerServiceImpl;

/*
 * author: Crunchify.com
 * 
 */

@Controller
public class CrunchifyHelloWorld {

	@Autowired
	private LogService<LogItem> logService;

	private static final Logger logger = Logger
			.getLogger(MongoDBLoggerServiceImpl.class);

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";

		ObjectId objectId = createLogItem(message);

		logger.info(String.format("Object ID created for logItem was [%s]",
				objectId));

		LogItem logItem = retrieveLogItem(objectId);

		logger.info(String
				.format("Logging message retrieved from newly created log item at [%s] was [%s]",
						logItem.getMessage(), logItem.getTimestamp()));

		return new ModelAndView("welcome", "message", message);
	}

	private ObjectId createLogItem(String message) {
		LogItem logItem = new LogItem();
		logItem.setMessage("I'm a logging message, hopefully I'll be stored");
		logItem.setTimestamp(new Date().toString());
		return logService.add(logItem);
	}

	private LogItem retrieveLogItem(ObjectId objectId) {
		return logService.get(objectId);
	}

}