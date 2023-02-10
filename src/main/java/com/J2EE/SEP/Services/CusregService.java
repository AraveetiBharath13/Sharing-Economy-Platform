package com.J2EE.SEP.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J2EE.SEP.Entity.CustomerRegistration;
import com.J2EE.SEP.Repository.CusregRepo;

@Service
public class CusregService {
	
	@Autowired
	CusregRepo cusregrepo;
	public void registerCustomer(CustomerRegistration cusreg) {
		cusregrepo.save(cusreg);
	}
	/*
	 * public CustomerRegistration Login(String CustomerId, String password ) {
	 * CustomerRegistration customer=
	 * cusregrepo.findByCustomeridAndPassword(CustomerId,password); return customer;
	 * }
	 */

}
