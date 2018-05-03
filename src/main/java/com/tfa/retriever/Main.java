package com.tfa.retriever;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.twitter.TwitterUtils;

import twitter4j.Status;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import com.tfa.retriever.Tweet;
import com.tfa.retriever.GeneradorDeTweet;
import com.tfa.retriever.MongoConnector;

/**
 * Main class to get in real time the tweets with the #BigData hashtag
 * 
 * @author Marcos Antonio Chamorro
 */
public class Main {

	private static final String TWITTER_CONSUMER_KEY = "fcyCZ3IbEIEoQTyga3PYbUzkM";
	private static final String TWITTER_SECRET_KEY = "5GRNcYO7QiLpHgHW22pgzUiOFX61OInizBWxOYWHP6d2RR1KHj";
	private static final String TWITTER_ACCESS_TOKEN = "164936578-keERLE7jTtXMNQwtm9Fv18mZ1fm8lvUj6oVpFsLe";
	private static final String TWITTER_ACCESS_TOKEN_SECRET = "vqwTdozZqVkK7OEfKzscJ28g93HOLGg3to24qnJw1sqbg";

	public static void main(String[] args) throws InterruptedException {

		// Setting twitter initial configuration
		ConfigurationBuilder confBuilder = new ConfigurationBuilder()
				.setDebugEnabled(true)
				.setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
				.setOAuthConsumerSecret(TWITTER_SECRET_KEY)
				.setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
		confBuilder.setJSONStoreEnabled(true);
		confBuilder.setIncludeEntitiesEnabled(true);
		
		Configuration twitterConf = confBuilder.build();
		Authorization twitterAuth = AuthorizationFactory.getInstance(twitterConf);

		// Setting Spark configuration and streaming context
		SparkConf sparkConf = new SparkConf().setAppName("Twitters").setMaster("local[2]");
		JavaStreamingContext javaStreamingContext = new JavaStreamingContext(sparkConf, new Duration(5000));

		// Preparing the filter, so that only tweets with the #BigData hashtag are retrieved
		String[] filters = { "#USA" };
		
		// Streaming
		long i = 20;
		TwitterUtils.createStream(javaStreamingContext, twitterAuth, filters)
				.map(tweet -> Main.printTweet(tweet, i)).print();
		javaStreamingContext.start();
		javaStreamingContext.awaitTermination();

	}
	
	public static String printTweet(Status statusTweet, long limite) {
		Tweet tweet = GeneradorDeTweet.generarTweet(statusTweet);
		MongoConnector mongoConn = new MongoConnector("localhost", 27017);
		mongoConn.crearTweetEn("PruebaMarzo", "doceMarzoOtraVez", tweet);
		if (limite <= mongoConn.cantidadDeDocumentos("PruebaMarzo", "doceMarzoOtraVez"))
		{
			System.out.println("Finalizando ejecución...");
			try {
				System.exit(0);
			} catch (Exception e) {
				System.out.println("TERMINADA");
			}
		}
			
		return "El tweet se ha guardado";
	}
	
	
}