package com.bway.springproject.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController {

	@RequestMapping(value="/gallery",method=RequestMethod.GET)
	public String viewGallery(Model model){
		
		List<String> imglist = Arrays.asList("01.jpg","003.jpg","004.jpg","005.jpg","006.jpg","007.jpg","008.jpg","02.jpg");
		model.addAttribute("imglist",imglist);
		
		return "gallery";
	}
}
