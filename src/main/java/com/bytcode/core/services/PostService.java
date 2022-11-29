package com.bytcode.core.services;

import java.util.List;
import com.bytcode.core.model.Post;


public interface PostService {
	public List<Post> validation(List<Post> posts) throws NullPointerException;
	
	public void addClass(Class clazz);
}
