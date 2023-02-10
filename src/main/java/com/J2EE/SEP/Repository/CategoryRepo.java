package com.J2EE.SEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.J2EE.SEP.Entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	//void deleteById(int id);

}
