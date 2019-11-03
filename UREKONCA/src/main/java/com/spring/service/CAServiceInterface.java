package com.spring.service;

import java.util.List;
import com.spring.entity.CA;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
public interface CAServiceInterface {

	public List<CA> findAll();

	public void save(CA ams);

	public CA findById(int theId); 

	public void deleteById(int theId);
	
	public List<CA> findByYear(String div);

	public List<CA> findByDept(String div);
	
	public List<CA> findByCourse(String div);
	
	public CA findByEnrl(String div);
	

}
