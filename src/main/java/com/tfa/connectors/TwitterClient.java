package com.tfa.connectors;

import java.io.IOException;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.twitter.TwitterUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfa.retriever.GeneradorDeTweet;
import com.tfa.retriever.Tweet;

import twitter4j.Status;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterClient {

    private static final String TWITTER_CONSUMER_KEY = "fcyCZ3IbEIEoQTyga3PYbUzkM";
    private static final String TWITTER_SECRET_KEY = "5GRNcYO7QiLpHgHW22pgzUiOFX61OInizBWxOYWHP6d2RR1KHj";
    private static final String TWITTER_ACCESS_TOKEN = "164936578-keERLE7jTtXMNQwtm9Fv18mZ1fm8lvUj6oVpFsLe";
    private static final String TWITTER_ACCESS_TOKEN_SECRET = "vqwTdozZqVkK7OEfKzscJ28g93HOLGg3to24qnJw1sqbg";

    public static void ingestContent(String keyword, String empresa,  long limit) {
        ConfigurationBuilder confBuilder = new ConfigurationBuilder()
                .setDebugEnabled(true).setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(TWITTER_SECRET_KEY)
                .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
        confBuilder.setJSONStoreEnabled(true);
        confBuilder.setIncludeEntitiesEnabled(true);

        Configuration twitterConf = confBuilder.build();
        Authorization twitterAuth = AuthorizationFactory
                .getInstance(twitterConf);

        SparkConf sparkConf = new SparkConf().setAppName("Twitters")
                .setMaster("local[2]");
        JavaStreamingContext javaStreamingContext = new JavaStreamingContext(
                sparkConf, new Duration(5000));

        String[] filters = { "#" + keyword };

        try {
            TwitterUtils.createStream(javaStreamingContext, twitterAuth, filters)
            .map(tweet -> TwitterClient.printTweet(tweet, empresa, limit)).print();
            javaStreamingContext.start();
            javaStreamingContext.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
            javaStreamingContext.close();
            return;
        }

    }

    private static String printTweet(Status statusTweet, String empresa, long limite) throws IOException {
    	System.out.println("Imprimiendo......");
    	System.out.println("Imprimiendo......");
    	System.out.println("Imprimiendo......");
    	System.out.println("Imprimiendo......");
    	System.out.println("Imprimiendo......");
    	ObjectMapper mapper = new ObjectMapper();
    	String status = mapper.writeValueAsString(statusTweet);
    	System.out.println(status);
    	
    	MongoConnector mongoConn = new MongoConnector();
        long cant = mongoConn.cantidadDeDocumentos(empresa);
        if (limite <= cant) {
            throw new IOException("Finalizando ejecución...");
        }
        Tweet tweet = GeneradorDeTweet.generarTweet(statusTweet);
        mongoConn.crearDocumento(empresa, tweet);

        return "El tweet se ha guardado";
    }

}
