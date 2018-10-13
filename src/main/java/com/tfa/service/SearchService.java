package com.tfa.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import com.mongodb.client.model.Filters;
import com.tfa.connectors.MongoConnector;
import com.tfa.retriever.Tweet;

@Service
public class SearchService {

    public List<Tweet> getTweets(String empresa, boolean titleNot, String title, boolean bodyNot,
    		String body, String operator) {
    	MongoConnector mongoConnector = new MongoConnector();
    	
    	if (StringUtils.isEmpty(title) && StringUtils.isEmpty(body)) {
    		return mongoConnector.obtenerTweetsDeMongo(empresa);
    	
    	} else {
    		Bson bsonTitle = null;
    		Bson bsonBody = null;
    		Bson query = null;
    		
    		if (!StringUtils.isEmpty(title))
    			bsonTitle = titleNot ? Filters.not(Filters.regex("cuerpoTweet", title)) : Filters.regex("cuerpoTweet", title);
    		
    		if (!StringUtils.isEmpty(body))
    			bsonBody = bodyNot ? Filters.not(Filters.regex("cuerpoTweet", body)) : Filters.regex("cuerpoTweet", body);
    		
    			
    		if (bsonTitle != null && bsonBody == null) {
    			query = bsonTitle;
    		} else if (bsonTitle == null && bsonBody != null) {
    			query = bsonBody;
    		} else {
    			query = (operator.equalsIgnoreCase("AND")) ? Filters.and(bsonTitle, bsonBody) : Filters.or(bsonTitle, bsonBody);
    		}
    		return mongoConnector.obtenerTweetsDeMongo(empresa, query);
    	}
    }

}