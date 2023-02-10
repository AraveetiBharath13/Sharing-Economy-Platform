package com.J2EE.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.J2EE.SEP.Entity.VendorRegistration;

@Repository
public interface VenregRepo extends JpaRepository<VendorRegistration, Integer> {

}
