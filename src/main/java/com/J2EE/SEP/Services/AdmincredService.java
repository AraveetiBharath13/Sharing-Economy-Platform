package com.J2EE.SEP.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J2EE.SEP.Entity.AdmincredEntity;
import com.J2EE.SEP.Entity.CustomerRegistration;
import com.J2EE.SEP.Repository.AdmincredRepo;

@Service
public class AdmincredService {

	@Autowired
	AdmincredRepo admincredrepo;
	
	public AdmincredEntity Login(String adminId, String password ) {
		 AdmincredEntity  admin=
				  admincredrepo.findByAdminIdAndPassword(adminId,password); 
		  return  admin;
		  }
}
