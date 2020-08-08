package com.ashokit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.models.SsnEnrollment;
import com.ashokit.service.SsnService;

@RestController
public class SsnEnrollmentRestController {
	
	@Autowired
	SsnService service;
	
	
	@PostMapping(
			value="/enrollment",
			consumes="application/json")
	public ResponseEntity<String> enrollment(@RequestBody SsnEnrollment request){
	ResponseEntity<String> response=null;
   Long ssn = service.ssnEnrollment(request);
   
   String body="Your SSN Enrollment completed SuccessFully SSN ::"+ssn;
   response=new ResponseEntity<>(body,HttpStatus.CREATED);
   return response;
    
	}

}
