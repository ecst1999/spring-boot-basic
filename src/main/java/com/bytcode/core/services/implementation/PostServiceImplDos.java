package com.bytcode.core.services.implementation;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bytcode.core.model.Post;
import com.bytcode.core.services.PostService;

@Service("serviceDos")
@Scope("singleton")
public class PostServiceImplDos implements PostService {

	private final Log log = LogFactory.getLog(getClass()); 
	
	@Override
	public List<Post> validation(List<Post> posts) throws  NullPointerException {		
		log.info("Servicio 2");
		for (Post post : posts) {
			if(post.getId() == 0) {
				throw new NullPointerException("El id esta nulo");
			}
		}
		return posts;
	}
	
	@Override
	public void addClass(Class clazz) {
		System.out.println(clazz.getName());
	}

}
