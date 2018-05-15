package com.tfa.connectors;

import org.bson.BSONException;
import org.bson.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tfa.retriever.Tweet;

public class MongoConnector {

    private MongoClientURI mongoUri;

    private static final String host = "ds225010.mlab.com";
    private static final String port = "25010";
    private static final String username = "marcoschamorro";
    private static final String password = "tfa";
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

}
