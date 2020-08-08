package com.ashokit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.StateMasterEntity;

@Repository
public interface StateMasterRepository extends JpaRepository<StateMasterEntity, Serializable>{
	
	@Query(value="select stateName from StateMasterEntity")
	public List<String> findStateName();

}
