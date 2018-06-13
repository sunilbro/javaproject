package com.bway.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.daos.StudentDao;
import com.bway.springproject.daos.UserDao;
import com.bway.springproject.models.User;

@Controller
public class LoginController {

	@Autowired
	private UserDao udao;
	
	@Autowired
	private StudentDao sdao;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String getLoginForm(){
		
		
		return "loginForm";
		
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String userLogin(@ModelAttribute User u,Model model){		//direct values----model--controller bata jsp ma pathaunako lagi
		
		if(udao.login(u.getUsername(), u.getPassword())){
			
			model.addAttribute("slist",sdao.getAllStudent());
			
			return "home";
		}
		
		return "loginForm";
		
	}
	
}
