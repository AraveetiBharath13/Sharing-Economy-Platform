package com.J2EE.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.J2EE.SEP.Entity.AdmincredEntity;

@Repository
public interface AdmincredRepo extends JpaRepository<AdmincredEntity, Integer> {
	
	AdmincredEntity findByAdminIdAndPassword(String adminId, String password );

}
