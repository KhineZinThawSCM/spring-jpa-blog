package com.kzt.blog.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * processLogin() { return "redirect:/posts"; }
	 */
}