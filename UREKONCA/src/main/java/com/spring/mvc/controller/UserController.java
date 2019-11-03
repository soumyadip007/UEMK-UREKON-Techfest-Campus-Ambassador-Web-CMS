package com.spring.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public UserController(CAService obj)
	{
		this.caService=obj;
	
	}
	


	@GetMapping("/index")
	public String all(Model theModel) {

		CA ca=new CA();
		
		theModel.addAttribute("ca",ca);
		
		
		return "user/index";
	}
	

	@PostMapping("/save")
	public String Saveca(@ModelAttribute("ca") CA ca) {


		caService.save(ca);
	
	
		return "redirect:/user/index";
	}
	


}