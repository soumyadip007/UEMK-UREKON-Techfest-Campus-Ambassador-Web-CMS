package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entity.CA;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Repository("caRepository")
public interface CARepository extends JpaRepository<CA, Integer> {

	List<CA> findByYear(String div);

	List<CA> findByDept(String div);
	
	List<CA> findByCourse(String div);
	
	CA findByEnrl(String div);
	

}