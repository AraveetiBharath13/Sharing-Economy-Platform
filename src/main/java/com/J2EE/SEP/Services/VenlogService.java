package com.J2EE.SEP.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.J2EE.SEP.Entity.VendorRegistration;
import com.J2EE.SEP.Repository.VenlogRepo;

@Service
public class VenlogService {
	
	@Autowired
	VenlogRepo venlogrepo;
	
	 public VendorRegistration Login(String vendorId, String password ) {
		  VendorRegistration vendor=
		  venlogrepo.findByVendorIdAndPassword(vendorId,password); 
		  return vendor;
		  }

}
