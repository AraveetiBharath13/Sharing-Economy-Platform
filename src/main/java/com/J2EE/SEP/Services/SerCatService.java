package com.J2EE.SEP.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J2EE.SEP.Entity.SerCatEntity;
import com.J2EE.SEP.Repository.ServiceCategoryRepo;

@Service
public class SerCatService {
	
	@Autowired
	ServiceCategoryRepo servicecategoryrepo ;
	public void createSerCategory(SerCatEntity sercategory) {
		servicecategoryrepo.save(sercategory);
	}
	
	public List<SerCatEntity> getAllCategory(){
		return servicecategoryrepo.findAll();
	}
	public void removeServiceById(int id) { servicecategoryrepo.deleteById(id);}
	
	/*
	 * @Autowired CategoryRepo categoryrepo; public void createCategory(Category
	 * category) { categoryrepo.save(category); }
	 */
}
