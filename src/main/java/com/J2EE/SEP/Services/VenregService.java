package com.J2EE.SEP.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J2EE.SEP.Entity.VendorRegistration;
import com.J2EE.SEP.Repository.VenregRepo;

@Service
public class VenregService {
	
	@Autowired
	VenregRepo venregrepo;
	public void registerVendor(VendorRegistration venreg ) {
		venregrepo.save(venreg);
	}

}
