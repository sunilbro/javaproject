package com.bway.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.daos.UserDao;
import com.bway.springproject.models.User;

@Controller
public class SignupController {

	@Autowired
	private UserDao udao;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getSignup(){
		
		
		return "signupForm";
		
	}

	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String userSignup(@ModelAttribute User u){
		
		udao.signup(u);
		
		return "loginForm";
		
	}
	
}
