package com.tfa.retriever;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import com.tfa.retriever.Tweet;
import com.tfa.retriever.Validaciones;

public class GeneradorDeTweet {
	@SuppressWarnings("deprecation")
	public static Tweet generarTweet(Status s_tweet) {
		Tweet tweet = new Tweet();
		String ubicacion = "";
		if (s_tweet.getUser().getLocation() == null) {
			ubicacion = "Sin ubicacion";
		} else {
			ubicacion = s_tweet.getUser().getLocation();
		}

		tweet.setUsuario(Validaciones.cadena(s_tweet.getUser().getName(), "Desconocido"));
		tweet.setFecha(Validaciones.entero(s_tweet.getCreatedAt().getDate(), 0));
		tweet.setCuerpoTweet(Validaciones.cadena(s_tweet.getText(), "No escribio nada"));
		tweet.setCantidadRetweet(Validaciones.entero(s_tweet.getRetweetCount(), 0));
		tweet.setCantidadFavoritos(Validaciones.entero(s_tweet.getFavoriteCount(), 0));
		tweet.setCantidadSeguidores(Validaciones.entero(s_tweet.getContributors().length, 0));
		tweet.setUbicacion(ubicacion);
		tweet.setIdioma(Validaciones.cadena(s_tweet.getLang(), "Desc."));
		StringBuilder listOfHash = new StringBuilder();
		for (HashtagEntity hashtagEntity : s_tweet.getHashtagEntities()) {
			listOfHash.append("#").append(hashtagEntity.getText()).append(", ");
		}
		String listaFinal = listOfHash.toString();
		if (listaFinal.length() < 3) {
			tweet.setListaHashtags("#HashTagRetuiteado");
		} else {
			tweet.setListaHashtags(listaFinal.substring(0, listaFinal.length() - 3));
		}
		
		return tweet;
	}

}