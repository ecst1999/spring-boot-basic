package com.bytcode.core.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytcode.core.model.Post;
import com.bytcode.core.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Override
	public List<Post> validationId(List<Post> posts) {
		System.out.println("Primer servicio");
		for (Post post : posts) {
			if(post.getTitulo() == null) {
				throw new NullPointerException("El titulo esta nulo");
			}
		}
		return posts;
	}

}
