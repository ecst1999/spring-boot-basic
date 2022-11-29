package com.bytcode.core.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.bytcode.core.model.Post;

@Component("com.bytcode.core.components.postComponent")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PostComponent {

	public List<Post> getPosts(){
		ArrayList<Post> posts = new ArrayList<>();
		
		posts.add(new Post(1, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/imagen.jpg", new Date(), "Desarrollo web"));
		posts.add(new Post(2, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/imagen.jpg", new Date(), "Desarrollo web Front-End"));
		posts.add(new Post(3, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/imagen.jpg", new Date(), "Desarrollo web Back-end"));
		posts.add(new Post(4, "Desarrollo web es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost/img/imagen.jpg", new Date(), "Desarrollo web UX UI"));
		return posts; 
	}
}
