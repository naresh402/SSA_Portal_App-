package com.ashokit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="SSN_MASTER")
@Data
public class SSNMasterEntity {
	
	@Id
	@GenericGenerator(name="ssn-gen",strategy="com.ashokit.generator.SsnGenerator")
	@GeneratedValue(generator="ssn_gen")
	@Column(name="SSN")
	private Long ssn;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="GENDER")
	private String gender;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE",updatable=false)
	private Date createdDate;
	
	@UpdateTimestamp
   	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE",insertable=false)
	private Date updatedDate;

}
