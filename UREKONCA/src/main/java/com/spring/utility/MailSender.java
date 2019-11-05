package com.spring.utility;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
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

public class MailSender{

	
	public void email(String emailSubject,String emailBody)
	{
		
		Properties emailProperties;
		Session mailSession;
		MimeMessage emailMessage;
		Transport transport;
		
		String emailPort = "587";//gmail's smtp port

		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");

		String toEmails ="amzallag.dan@gmail.com";
		

		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		//for (int i = 0; i < toEmails.length; i++) {
			try {
				emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails));
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	
			try {
				emailMessage.setSubject(emailSubject);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			try {
				emailMessage.setContent(emailBody, "text/html");
			} catch (MessagingException e1) {
				e1.printStackTrace();
			}
			
			String emailHost = "smtp.gmail.com";
			String fromUser = "lightningspeedmatchmaker@gmail.com";
			String fromUserEmailPassword = "Matchmadeinheaven2015%$#@";

			
			try {
				transport = mailSession.getTransport("smtp");
			

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
			catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//out.println("Email sent successfully.");
		
		}
	}