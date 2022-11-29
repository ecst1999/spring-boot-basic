package com.bytcode.core.services.implementation;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bytcode.core.model.Post;
import com.bytcode.core.services.PostService;

@Service("serviceDecorado")
public class PostServiceDecoradoImpl implements PostService {
	
	private final Log log = LogFactory.getLog(getClass()); 

	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@Autowired
	private PostServiceImplDos postServiceImplDos;
	
	@Override
	public List<Post> validation(List<Post> posts) {
		log.debug(posts);
		posts = postServiceImpl.validation(posts);
		posts = postServiceImplDos.validation(posts);
		
		for (Post post : posts) {
			if(post.getDescripcion() == null) {
				throw new NullPointerException("La descripción esta nulo");
			}
			
			if(post.getFecha() == null) {
				throw new NullPointerException("La fecha esta nulo");
			}
		}
		
		return posts;
	}

	@Override
	public void addClass(Class clazz) {
		System.out.println(clazz.getName());
	}

}
