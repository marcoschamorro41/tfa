package com.tfa.connectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.BSONException;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tfa.retriever.Tweet;
import com.tfa.utils.DefaultJsonParser;

public class MongoConnector {

    private MongoClientURI mongoUri;

    private static final String host = "ds225010.mlab.com";
    private static final String port = "25010";
    private static final String username = "juangoody";
    private static final String password = "jmg.2112";
    private static final String databaseName = "tfa";

    public MongoConnector() {
        mongoUri = new MongoClientURI("mongodb://" + username + ":" + password
                + "@" + host + ":" + port + "/" + databaseName);
   }

    public void crearDocumento(String empresa, Tweet tweet) {
        try {
            MongoClient mongoClient = new MongoClient(mongoUri);
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database
                    .getCollection(empresa);
            ObjectMapper mapper = new ObjectMapper();
            String jsonTweet = mapper.writeValueAsString(tweet);
            Document doc = Document.parse(jsonTweet);
            collection.insertOne(doc);
            mongoClient.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (BSONException e) {
            System.out.println(e.getMessage());
        }

    }

    public long cantidadDeDocumentos(String empresa) {
        MongoClient mongoClient = new MongoClient(mongoUri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(empresa);
        long count = collection.count();
        mongoClient.close();
        return count;
    }

    public List<Tweet> obtenerTweetsDeMongo(String empresa) {
    	MongoClient mongoClient = new MongoClient(mongoUri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(empresa);
        List<Tweet> list = new ArrayList<Tweet>();
        FindIterable<Document> iterable = collection.find();
        iterable.forEach((Block<Document>) d -> 
        	list.add(DefaultJsonParser.getObjectFromJson(Tweet.class, d.toJson())));
        mongoClient.close();
        return list;
    }
    
    public List<Tweet> obtenerTweetsDeMongo(String empresa, Bson query) {
    	MongoClient mongoClient = new MongoClient(mongoUri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(empresa);
        List<Tweet> list = new ArrayList<Tweet>();
        FindIterable<Document> iterable = collection.find(query);
        iterable.forEach((Block<Document>) d -> 
        	list.add(DefaultJsonParser.getObjectFromJson(Tweet.class, d.toJson())));
        mongoClient.close();
        return list;
    }
    
    public List<Tweet> obtenerTweetsDeMongo(String empresa, String pribus, String condition, String secbus) {
    	
    	BasicDBObject inQuery = new BasicDBObject();
     
       // inQuery.put("cuerpoTweet", new BasicDBObject("$in", pribus));
        //inQuery.put("cuerpoTweet", pribus);
    	
    	inQuery.put("cuerpoTweet",
                new BasicDBObject("$regex", pribus)
                .append("$options", "i"));
    	
    	MongoClient mongoClient = new MongoClient(mongoUri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(empresa);
        List<Tweet> list = new ArrayList<Tweet>();
        FindIterable<Document> iterable = collection.find(inQuery);
        iterable.forEach((Block<Document>) d -> 
        	list.add(DefaultJsonParser.getObjectFromJson(Tweet.class, d.toJson())));
        mongoClient.close();
        return list;
    }
    
    public int obtenerCantPAISDeMongo(String empresa, String pais) {
    	
    	BasicDBObject inQuery = new BasicDBObject();
     
       // inQuery.put("cuerpoTweet", new BasicDBObject("$in", pribus));
        //inQuery.put("cuerpoTweet", pribus);
    	
    	inQuery.put("ubicacion",
                new BasicDBObject("$regex", pais)
                .append("$options", "i"));
    	
    	MongoClient mongoClient = new MongoClient(mongoUri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(empresa);
        List<Tweet> list = new ArrayList<Tweet>();
        FindIterable<Document> iterable = collection.find(inQuery);
        iterable.forEach((Block<Document>) d -> 
        	list.add(DefaultJsonParser.getObjectFromJson(Tweet.class, d.toJson())));
        mongoClient.close();
        return list.size();
    }
    
    
public void mencionesFecha(String empresa) {

	MongoClient mongoClient = new MongoClient(mongoUri);
    MongoDatabase database = mongoClient.getDatabase(databaseName);
    database.getCollection(empresa).aggregate(Arrays.asList(new Document("$group", new Document("_id", "$fecha"))));
    
}
}
