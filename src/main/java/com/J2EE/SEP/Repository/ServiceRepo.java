package com.J2EE.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.J2EE.SEP.Entity.ServiceEntity;

@Repository
public interface ServiceRepo extends JpaRepository<ServiceEntity, Integer>{

}
