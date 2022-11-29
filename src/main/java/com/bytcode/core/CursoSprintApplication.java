package com.bytcode.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	
	public PostService getPostService() {
		return postService;
	}
	
	public CursoSprintApplication() {
		
	}
	
	@Autowired
	public CursoSprintApplication(@Qualifier("serviceDecorado") PostService postService) {		
		this.postService = postService;		
	}

	public PostService postService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSprintApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Log log = LogFactory.getLog(getClass());
		try {
			postService.validation(postComponent.getPosts())
			.forEach((post) -> {
				log.info(post.getTitulo());
			});
		}catch (Exception e) {
			log.error(e);			
		}
		
	}

}
