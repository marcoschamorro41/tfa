package com.tfa.retriever;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tweet {

	@JsonProperty("fecha")
	private int fecha;
	
	@JsonProperty("usuario")
	private String usuario;
	
	@JsonProperty("cuerpoTweet")
	private String cuerpoTweet;
	
	@JsonProperty("cantidadRetweet")
	private int cantidadRetweet;
	
	@JsonProperty("cantidadFavoritos")
	private int cantidadFavoritos;
	
	@JsonProperty("cantidadSeguidores")
	private int cantidadSeguidores;
	
	@JsonProperty("ubicacion")
	private String ubicacion;
	
	@JsonProperty("idioma")
	private String idioma;
	
	@JsonProperty("listaHashtags")
	private String listaHashtags;
	
	
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCuerpoTweet() {
		return cuerpoTweet;
	}
	public void setCuerpoTweet(String cuerpoTweet) {
		this.cuerpoTweet = cuerpoTweet;
	}
	public int getCantidadRetweet() {
		return cantidadRetweet;
	}
	public void setCantidadRetweet(int cantidadRetweet) {
		this.cantidadRetweet = cantidadRetweet;
	}
	public int getCantidadFavoritos() {
		return cantidadFavoritos;
	}
	public void setCantidadFavoritos(int cantidadFavoritos) {
		this.cantidadFavoritos = cantidadFavoritos;
	}
	public int getCantidadSeguidores() {
		return cantidadSeguidores;
	}
	public void setCantidadSeguidores(int cantidadSeguidores) {
		this.cantidadSeguidores = cantidadSeguidores;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
		
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getListaHashtags() {
		return listaHashtags;
	}
	public void setListaHashtags(String listaHashtags) {
		this.listaHashtags = listaHashtags;
	}
	
	

}
