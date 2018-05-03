package com.tfa.retriever;


import org.bson.BSONException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
//import com.mongodb.util.JSON;
import com.mongodb.util.JSON;

import com.tfa.retriever.Tweet;

@SuppressWarnings("deprecation")
public class MongoConnector {

	private Mongo mongo;

	@SuppressWarnings("deprecation")
	public MongoConnector(String host, int puerto) {
		mongo = new Mongo(host, puerto);
	}

	@SuppressWarnings({ "deprecation" })
	public void crearTweetEn(String baseDeDatos, String coleccion, Tweet tweet) {
		try {
			DB db = mongo.getDB(baseDeDatos);
			DBCollection coll = db.getCollection(coleccion);
			ObjectMapper mapper = new ObjectMapper();
			String jsonTweet = mapper.writeValueAsString(tweet);
			DBObject doc = (DBObject) JSON.parse(jsonTweet);
			coll.insert(doc);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (BSONException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public long cantidadDeDocumentos(String baseDeDatos, String coleccion) {
		try {
			DB db = mongo.getDB(baseDeDatos);
			DBCollection coll = db.getCollection(coleccion);
			return coll.count();
			

		} catch (BSONException e) {
			System.out.println(e.getMessage());
		}
		
		return 0;
	}

}
