package com.bytcode.core.model;

import java.util.Date;

public class Post {
	private int id;
	private String descripcion;
	private String urlImag = "http://localhost/img/imagen.jpg";
	private Date fecha;
	private String titulo;
	
	
	
	public Post(int id, String descripcion, String urlImag, Date fecha, String titulo) {
		this.id = id;
		this.descripcion = descripcion;
		this.urlImag = urlImag;
		this.fecha = fecha;
		this.titulo = titulo;
	}
	
	
	
	public Post() {		
	}



	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrlImag() {
		return this.urlImag;
	}
	public void setUrlImag(String urlImag) {
		this.urlImag = urlImag;
	}
	public Date getFecha() {
		return this.fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
