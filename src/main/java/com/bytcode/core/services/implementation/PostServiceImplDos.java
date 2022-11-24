package com.bytcode.core.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytcode.core.model.Post;
import com.bytcode.core.services.PostService;

@Service("serviceDos")
public class PostServiceImplDos implements PostService {

	@Override
	public List<Post> validationId(List<Post> posts) {
		System.out.println("Segundo servicio");
		for (Post post : posts) {
			if(post.getId() == 0) {
				throw new NullPointerException("El id esta nulo");
			}
		}
		return posts;
	}

}
