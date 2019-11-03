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
@Table(name = "ams")
public class AMS {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "course")
	private String course;
	
	@Column(name = "dept")
	private String dept;
	
	@Column(name = "enrl")
	private String enrl;
	
	@Column(name = "dgpa")
	private String dgpa;
	

	@Column(name = "chapter")
	private String chapter;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "ph")
	private String ph;
	

	@Column(name = "achivements")
	private String achivements;
	
	@Column(name = "placed")
	private String placed;
	
	@Column(name = "image")
	private String image;
	

	@Column(name = "click")
	@Transient
	private int click;
	



}