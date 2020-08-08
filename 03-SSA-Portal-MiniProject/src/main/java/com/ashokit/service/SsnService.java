package com.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashokit.models.SsnEnrollment;


@Service
public interface SsnService {
	
	public List<String> getAllStateName();
	
	public Long ssnEnrollment(SsnEnrollment req);
	
	public String checkEnrollment(Long ssn, String stateName);

}
