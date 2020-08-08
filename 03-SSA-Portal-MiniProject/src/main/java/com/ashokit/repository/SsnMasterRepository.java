package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.SSNMasterEntity;

public interface SsnMasterRepository extends JpaRepository<SSNMasterEntity, Serializable>{
	
	public SSNMasterEntity findBySsnAndStateName(Long ssn,String stateName);

}
