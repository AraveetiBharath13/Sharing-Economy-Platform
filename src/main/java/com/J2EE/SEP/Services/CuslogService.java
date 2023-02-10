package com.J2EE.SEP.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J2EE.SEP.Entity.CustomerRegistration;
import com.J2EE.SEP.Repository.CuslogRepo;

@Service
public class CuslogService {
	
	@Autowired
	CuslogRepo cuslogrepo;
	
	  
	
	  public CustomerRegistration Login(String customerId, String password ) {
	  CustomerRegistration customer=
	  cuslogrepo.findByCustomerIdAndPassword(customerId,password); 
	  return customer;
	  }
	 

}
