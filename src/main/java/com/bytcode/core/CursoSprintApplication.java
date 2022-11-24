package com.bytcode.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bytcode.core.components.PostComponent;
import com.bytcode.core.model.Conexion;
import com.bytcode.core.services.PostService;

@SpringBootApplication
public class CursoSprintApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("beanConexion")
	private Conexion conexion;
	
	@Autowired
	@Qualifier("com.bytcode.core.components.postComponent")
	public PostComponent postComponent;
	
	@Autowired
	@Qualifier("serviceDos")
	public PostService postService;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSprintApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postService.validationId(postComponent.getPosts())
			.forEach((post) -> {
				System.out.println(post.getTitulo());
			});
	}

}
