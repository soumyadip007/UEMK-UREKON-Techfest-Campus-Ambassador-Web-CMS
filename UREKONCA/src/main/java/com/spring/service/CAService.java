package com.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CARepository;
import com.spring.entity.CA;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Service
public class CAService implements CAServiceInterface {

	
	private CARepository amsRepository;
	

	@Autowired   
	public CAService(CARepository obj)
	{
		amsRepository=obj;
	}
	
	
	@Override
	public List<CA> findAll() {
	
		return amsRepository.findAll();
	}

	@Override
	public void save(CA ams) {
		
		amsRepository.save(ams);
	}

	@Override
	public CA findById(int theId) {
		
		Optional<CA> result=amsRepository.findById(theId);
		
		CA ams=null;
		
		if(result.isPresent())
		{
			ams=result.get();
		}
		else {
			throw new RuntimeException("Did not find ams id - " + theId);
		}
		return  ams;
	}


	@Override
	public void deleteById(int theId) {
		amsRepository.deleteById(theId);
	}




}
