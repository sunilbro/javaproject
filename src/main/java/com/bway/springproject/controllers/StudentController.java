package com.bway.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.daos.StudentDao;
import com.bway.springproject.models.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDao sdao;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String getStudentForm(Model model){
		
		model.addAttribute("stud",new Student());					//save student's object in the key "stud" that binds the values.
		
		return "studentForm";
		
	}
	
	
	@RequestMapping(value = "/student",method = RequestMethod.POST)
	@Transactional
	public String saveStudent(@ModelAttribute Student s, Model model){
		
		sdao.addStudent(s);
		
		model.addAttribute("slist",sdao.getAllStudent());
		
		return "home";
		
	}
	
	@RequestMapping(value = "/{id}/delete",method = RequestMethod.GET)
	public String deleteStud(@PathVariable("id") int id, Model model){
		
		sdao.deleteStudent(id);
		model.addAttribute("slist",sdao.getAllStudent());
		return "home";
		
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	@Transactional
	public String editStud(@PathVariable("id")int id, Model model){
		
		model.addAttribute("stud",sdao.getById(id));
		
		return "editForm";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@Transactional
	public String updateStud(@ModelAttribute Student s,Model model){
		
		sdao.updateStudent(s);
		model.addAttribute("slist",sdao.getAllStudent());
		return "home";
	}
	
	
	
	
}
