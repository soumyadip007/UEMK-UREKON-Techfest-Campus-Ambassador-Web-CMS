package com.spring.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.CA;
import com.spring.service.AMSService;
/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	

	private AMSService amsService;
	@Autowired   
	public UserController(AMSService obj)
	{
		this.amsService=obj;
	
	}

	
	
	@GetMapping("/ca")
	public String Allca(@RequestParam("id") int theId,Model theModel) {

	
		System.out.println(list);
		return "user/ca-details";
	}



	@GetMapping("/index")
	public String all(Model theModel) {

		List<CA> list=amsService.findAll();
		
		theModel.addAttribute("allca",list);
		
		return "user/index";
	}
	
	


}