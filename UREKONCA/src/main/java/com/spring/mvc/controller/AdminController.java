package com.spring.mvc.controller;


import java.security.NoSuchProviderException;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.CA;
import com.spring.entity.Email;
import com.spring.service.CAService;
/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	

	private CAService amsService;
	@Autowired   
	public AdminController(CAService obj)
	{
		this.amsService=obj;
	
	}


	@GetMapping("/add-ca")
	public String all(Model theModel) {

		CA ca=new CA();
		
		theModel.addAttribute("ca",ca);
		
		
		return "dashboard/addCA";
	}
	
	@PostMapping("/add-ca")
	public String Saveca(@ModelAttribute("ca") CA ca) {

	
		amsService.save(ca);
	
		return "redirect:/admin/add-ca";
	}
	
	@GetMapping("/all-ca")
	public String Allca(Model theModel) {

		List<CA> list=amsService.findAll();
		
		theModel.addAttribute("allca",list);
		
		return "dashboard/caList";
	}

	
	@GetMapping("/update-ca")
	public String Updateca(@RequestParam("id") int theId,Model theModel) {

		CA ca=amsService.findById(theId);
		
		theModel.addAttribute("ca",ca);
		
		return "dashboard/addca";
	}
	
	
	@GetMapping("/view-ca")
	public String ViewCa(@RequestParam("id") int theId,Model theModel) {

		CA ca=amsService.findById(theId);
		
		theModel.addAttribute("ca",ca);
		
		return "dashboard/viewCA";
	}
	@GetMapping("/delete-ca")
	public String Deleteca(@RequestParam("id") int theId) {

		amsService.deleteById(theId);
	
		return "redirect:/admin/all-ca";
	}

	

	
	@GetMapping("/email")
	public String Emaial(Model theModel) {
	
		Email obj=new Email();
		
		theModel.addAttribute("ca",obj);
		
		return "dashboard/email";
		
	}
	
	@PostMapping("/email")
	public String Emails(Model theModel) {

		Properties emailProperties;
		Session mailSession;
		MimeMessage emailMessage;
		Transport transport = null;
		
		
		Email ca=new Email();

		
		String emailPort = "587";

		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		
		
		String[] toEmails=new String[10] ;
		toEmails[0]=ca.getEmail();
		String emailSubject =ca.getSub();
		String emailBody = ca.getBody();

		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		for (int i = 0; i < toEmails.length; i++) {
			try {
				emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			try {
				emailMessage.setSubject(emailSubject);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				emailMessage.setContent(emailBody, "text/html");
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//for a html email
			//emailMessage.setText(emailBody);// for a text email
			
			String emailHost = "smtp.gmail.com";
			String fromUser = "lightningspeedmatchmaker@gmail.com";//just the id alone without @gmail.com
			String fromUserEmailPassword = "Matchmadeinheaven2015%$#@";

			
			try {
				transport.connect(emailHost, fromUser, fromUserEmailPassword);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
				
				
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				transport.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		theModel.addAttribute("ca",ca);
}
}
