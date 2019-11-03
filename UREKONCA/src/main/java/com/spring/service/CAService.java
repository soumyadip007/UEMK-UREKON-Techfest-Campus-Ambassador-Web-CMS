package com.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.AMSRepository;
import com.spring.entity.CA;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Service
public class CAService implements AMSServiceInterface {

	
	private AMSRepository amsRepository;
	

	@Autowired   
	public CAService(AMSRepository obj)
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


	@Override
	public List<CA> findByYear(String year) {
		
	return amsRepository.findByYear(year);
	}


	@Override
	public List<CA> findByDept(String dept) {
		
		return amsRepository.findByDept(dept);
	}


	@Override
	public List<CA> findByCourse(String course) {
		
		return amsRepository.findByCourse(course);
	}

	@Override
	public CA findByEnrl(String course) {
		
		return amsRepository.findByEnrl(course);
	}
//
//	@Override
//	public List<AMS> findByDivision(String div) {
//	
////		Optional<ams> result=amsRepository.findByDivision(div);
////		
////		List<ams> ams=null;
////		
////		if(result.isPresent())
////		{
////			ams.add(result.get());
////		}
////		else {
////			throw new RuntimeException("Did not find ams div - " + div);
////		}
//		
//		return amsRepository.findByDivision(div);
//	}
//
//
//	@Override
//	public List<AMS> findByArea(String area) {
//		
//		return amsRepository.findByArea(area);
//	}

}
