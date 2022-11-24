package com.bytcode.core.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.bytcode.core.model.Conexion;
import com.bytcode.core.model.Usuario;

@Component
public class CreandoConexion {
	
	@Bean(name = "beanUsuario")
	public Usuario getUsuario() {
		return new Usuario();
	}
	
	@Bean(name = "beanConexion")
	public Conexion getConexion() {
		Conexion conexion = new Conexion();
		
		conexion.setDb("mysql");
		conexion.setUrl("localhost");
		
		return conexion; 
	}
	
}
