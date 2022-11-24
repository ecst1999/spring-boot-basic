package com.bytcode.core.controllers;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bytcode.core.components.PostComponent;
import com.bytcode.core.configuration.Page;
import com.bytcode.core.model.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {

	
	@Autowired
	private PostComponent _postComponent;
	
	@GetMapping(path = {"/posts", "/"})
	public String saludar(Model model) {
		model.addAttribute("posts", _postComponent.getPosts());
		return "index";
	}
	
	@GetMapping(path = "/public")
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Page.HOME);
		modelAndView.addObject("posts", _postComponent.getPosts());
		return modelAndView;
	}
	
	@GetMapping(path = {"/post"})
	public ModelAndView getPostIndividuals(
			@RequestParam(defaultValue = "1", name="id", required = false) int id
			) {
		ModelAndView modelAndView = new ModelAndView(Page.POST);
		List<Post> postFiltrado = _postComponent.getPosts().stream()
										.filter((p) -> {
											return p.getId() == id;
										}).collect(Collectors.toList());
		
		modelAndView.addObject("post", postFiltrado.get(0));
		return modelAndView;
		
	}
	
	@GetMapping(path = "/postNew")
	public ModelAndView getForm() {
		return new ModelAndView(Page.FORM).addObject("post", new Post());
	}
	
	@PostMapping(path = "/addNewPost")
	public String addNewPost(Post post, Model model) {
		List<Post> posts = _postComponent.getPosts();
		posts.add(post);
		model.addAttribute("posts", posts);
		return Page.HOME;
	}
	
	@GetMapping(path = {"/post", "/post/{post}"})
	public ModelAndView getPostIndividual(
			@PathVariable(required = true, name="post") int id			
			) {
		ModelAndView modelAndView = new ModelAndView(Page.POST);
		List<Post> postFiltrado = _postComponent.getPosts().stream()
										.filter((p) -> {
											return p.getId() == id;
										}).collect(Collectors.toList());
		
		modelAndView.addObject("post", postFiltrado.get(0));
		return modelAndView;
		
	}
}
