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
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	

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
	
	
	@Column(name = "Why")
	private String Why;
	
	@Column(name = "startup")
	private String startup;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getYr() {
		return yr;
	}

	public void setYr(String yr) {
		this.yr = yr;
	}

	public String getEntrepreneurship() {
		return entrepreneurship;
	}

	public void setEntrepreneurship(String entrepreneurship) {
		this.entrepreneurship = entrepreneurship;
	}

	public String getInvolvements() {
		return involvements;
	}

	public void setInvolvements(String involvements) {
		this.involvements = involvements;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getWhy() {
		return Why;
	}

	public void setWhy(String why) {
		Why = why;
	}

	public String getStartup() {
		return startup;
	}

	public void setStartup(String startup) {
		this.startup = startup;
	}

	@Override
	public String toString() {
		return "AMS [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", college=" + college
				+ ", yr=" + yr + ", entrepreneurship=" + entrepreneurship + ", involvements=" + involvements + ", ph="
				+ ph +  ", Why=" + Why + ", startup=" + startup + "]";
	}

	


}