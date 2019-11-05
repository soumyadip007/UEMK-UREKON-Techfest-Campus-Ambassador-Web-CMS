package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;
/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
public class Email {

	String email;
	
	String sub;
	
	String body;

}