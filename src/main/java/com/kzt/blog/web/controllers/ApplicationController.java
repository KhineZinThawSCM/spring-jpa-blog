package com.kzt.blog.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kzt.blog.persistence.repositories.RoleRespository;

@Controller
public class ApplicationController {
	@Autowired
	RoleRespository roleRespository;

	@GetMapping("/")
	public String home(Authentication authentication) {
		 // Check if the user has the role ROLE_ADMIN
	    if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
	        return "redirect:/users";
	    } else {
	        return "redirect:/posts";
	    }
	}
}
