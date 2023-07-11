package com.kzt.blog.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kzt.blog.bl.dto.post.PostDTO;
import com.kzt.blog.bl.dto.user.UserDTO;
import com.kzt.blog.bl.services.post.PostService;
import com.kzt.blog.bl.services.user.UserService;
import com.kzt.blog.persistence.entities.User;
import com.kzt.blog.web.forms.PostForm;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/posts")
	public ModelAndView index() {
		List<PostDTO> posts = this.postService.getAllPosts();
		ModelAndView mv = new ModelAndView("posts/index");
		mv.addObject("posts", posts);
		return mv;
	}
	
	@RequestMapping("/posts/create")
	public ModelAndView create() {
		List<UserDTO> users = this.userService.getAllUsers();
		ModelAndView mv = new ModelAndView("posts/create");
		mv.addObject("users", users);
		mv.addObject("postForm", new PostForm());
		return mv;
	}
	
	@RequestMapping(value = "/posts/store", method = RequestMethod.POST)
	public ModelAndView store(@ModelAttribute("postForm") @Valid PostForm postForm,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors()) {
			List<UserDTO> users = this.userService.getAllUsers();
			mv.addObject("users", users);
			mv.setViewName("posts/create");
			return mv;
		}
		
		this.postService.savePost(postForm);
		mv.setViewName("redirect:/posts");
		return mv;
	}
	
	@RequestMapping("/posts/edit")
	public ModelAndView edit(@RequestParam("id") Long id) {
		PostDTO postDTO = this.postService.getPostById(id);
		List<UserDTO> users = this.userService.getAllUsers();
		ModelAndView mv = new ModelAndView("posts/edit");
		mv.addObject("users", users);
		mv.addObject("postForm", new PostForm(postDTO));
		return mv;
	}
	
	@RequestMapping(value = "/posts/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("postForm") PostForm postForm,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors()) {
			List<UserDTO> users = this.userService.getAllUsers();
			mv.addObject("users", users);
			mv.setViewName("posts/edit");
			return mv;
		}
		
		this.postService.updatePost(postForm);
		mv.setViewName("redirect:/posts");
		return mv;
	}
	
	@RequestMapping("/posts/destroy")
	public String destroy(@RequestParam("id") Long id) {
		this.postService.deletePostById(id);
		
		return "redirect:/posts";
	}
}
