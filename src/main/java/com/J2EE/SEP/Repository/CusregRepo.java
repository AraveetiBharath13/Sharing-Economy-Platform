package com.J2EE.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.J2EE.SEP.Entity.CustomerRegistration;

@Repository
public interface CusregRepo extends JpaRepository<CustomerRegistration, Integer > {
	
	/*
	 * CustomerRegistration findByCustomeridAndPassword(String CustomerId, String
	 * password );
	 */

}
