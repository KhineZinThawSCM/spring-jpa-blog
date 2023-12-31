package com.kzt.blog.web.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kzt.blog.bl.services.user.UserService;
import com.kzt.blog.bl.dto.user.UserDTO;
import com.kzt.blog.web.forms.UserForm;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public ModelAndView index() {
		List<UserDTO> users = this.userService.getAllUsers();
		ModelAndView mv = new ModelAndView("users/index");
		mv.addObject("users", users);
		return mv;
	}

	@RequestMapping("/users/create")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView("users/create");
		mv.addObject("userForm", new UserForm());
		return mv;
	}

	@RequestMapping(value = "/users/store", method = RequestMethod.POST)
	public ModelAndView store(@ModelAttribute("userForm") @Valid  UserForm userForm,
			BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mv.setViewName("users/create");
			return mv;
		}

		userService.saveUser(userForm);
		mv.setViewName("redirect:/users");
		return mv;
	}
	
	@RequestMapping("/users/edit")
	public ModelAndView edit(@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView("users/edit");
		UserDTO userDTO = this.userService.getUserById(id);
		mv.addObject("userForm", new UserForm(userDTO));
		return mv;
	}
	
	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("userForm") @Valid  UserForm userForm,
			BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mv.setViewName("users/edit");
			return mv;
		}

		userService.updateUser(userForm);
		mv.setViewName("redirect:/users");
		return mv;
	}
	
	@RequestMapping("/users/destroy")
	public String destroy(@RequestParam("id") Long id) {
		this.userService.deleteUserById(id);
		
		return "redirect:/users";
	}
	
	@RequestMapping("/users/search")
	public ModelAndView search(@RequestParam("keyword") String keyword) {
		List<UserDTO> users = this.userService.search(keyword);
		ModelAndView mv = new ModelAndView("users/index");
		mv.addObject("users", users);
		return mv;
	}
	
	
	 
	
}
