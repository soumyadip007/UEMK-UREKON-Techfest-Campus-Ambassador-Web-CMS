package com.spring.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.AMS;
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

	
	
	@GetMapping("/alumni")
	public String Allalumni(@RequestParam("id") int theId,Model theModel) {

		AMS list=(AMS) amsService.findById(theId);
		
		int click=list.getClick();
		
		click++;
		
		list.setClick(click);
		

		amsService.save(list);
	
		
		theModel.addAttribute("list",list);
		
		System.out.println(list);
		return "user/alumni-details";
	}



	@GetMapping("/index")
	public String all(Model theModel) {

		List<AMS> list=amsService.findAll();
		
		theModel.addAttribute("allalumni",list);
		
		return "user/index";
	}
	
	


}