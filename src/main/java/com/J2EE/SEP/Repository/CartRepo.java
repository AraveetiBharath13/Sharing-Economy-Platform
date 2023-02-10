package com.J2EE.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.J2EE.SEP.Entity.CartEntity;

@Repository
public interface CartRepo extends JpaRepository<CartEntity, Integer> {
	
	

}
