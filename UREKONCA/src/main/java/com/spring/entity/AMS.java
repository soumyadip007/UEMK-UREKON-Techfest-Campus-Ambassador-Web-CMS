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
@Entity
@Table(name = "ca")
public class AMS {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "course")
	private String course;
	
	@Column(name = "ph")
	private String ph;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "college")
	private String college;
	

	@Column(name = "yr")
	private String yr;
	
	
	@Column(name = "entrepreneurship")
	private String entrepreneurship;
	
	@Column(name = "involvements")
	private String involvements;
	
	@Column(name = "ph")
	private String ph;
	

	@Column(name = "achivements")
	private String achivements;
	
	@Column(name = "Why")
	private String Why;
	
	@Column(name = "startup")
	private String startup;

	


}