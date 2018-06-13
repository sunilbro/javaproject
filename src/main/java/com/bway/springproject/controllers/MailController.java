package com.bway.springproject.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.daos.StudentDao;




@Controller
public class MailController {
	
	@Autowired
	private StudentDao sdao;

	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String emailPage() {

		return "email";
	}

	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public String sendEmail(HttpServletRequest request, Model model) {

		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String msg = request.getParameter("msg");

		Mailer.send(to, subject, msg);

		model.addAttribute("slist", sdao.getAllStudent());
		
		return "home";
	}

}
