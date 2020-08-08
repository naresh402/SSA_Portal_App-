package com.ashokit.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.SSNMasterEntity;
import com.ashokit.exception.InvalidSSN;
import com.ashokit.exception.NotFoundSSNException;
import com.ashokit.models.SsnEnrollment;
import com.ashokit.repository.SsnMasterRepository;
import com.ashokit.repository.StateMasterRepository;

@Service
public class SsnServiceImpl implements SsnService {
	
	@Autowired
	StateMasterRepository stateRepo;
	
	@Autowired
	SsnMasterRepository ssnRepo;

	@Override
	public List<String> getAllStateName() {
		List<String> findStateName = stateRepo.findStateName();
		return findStateName;
	}

	@Override
	public Long ssnEnrollment(SsnEnrollment req) {
		SSNMasterEntity entity=new SSNMasterEntity();
		BeanUtils.copyProperties(req, entity);
         SSNMasterEntity saveEntity = ssnRepo.save(entity);
         if(saveEntity!=null)
         {
        	 return saveEntity.getSsn();
         }
         
         else {
        	 throw new NotFoundSSNException("No SSN Found");
         }
	}

	@Override
	public String checkEnrollment(Long ssn, String stateName) {
		SSNMasterEntity ssnEntity = ssnRepo.findBySsnAndStateName(ssn, stateName);
		if(ssnEntity!=null) {
			return "Valid";
		}
		else
		{
			throw new InvalidSSN("Invalid SSN");
		}
	}

}
