package com.spring.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.CA;
import com.spring.service.CAService;
/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	

	private CAService caService;
	@Autowired   
	public UserController(caService obj)
	{
		this.caService=obj;
	
	}

	


	@GetMapping("/index")
	public String all(Model theModel) {

		List<CA> list=caService.findAll();
		
		theModel.addAttribute("allca",list);
		
		return "user/index";
	}
	
	


}