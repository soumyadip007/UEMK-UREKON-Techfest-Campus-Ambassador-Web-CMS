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


}
