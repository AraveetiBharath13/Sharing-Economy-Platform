package com.J2EE.SEP.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J2EE.SEP.Entity.Category;
import com.J2EE.SEP.Repository.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepo categoryrepo;
	public void createCategory(Category category) {
		categoryrepo.save(category);
	}
	
	public List<Category> getAllCategory(){
		return categoryrepo.findAll();
	}
	
	public void removeCategoryById(int id) { categoryrepo.deleteById(id);}
	public Optional<Category> getCatgeoryById(int id) {return categoryrepo.findById(id);}
	
	/*
	 * @Autowired CategoryRepo categoryrepo; public void createCategory(Category
	 * category) { categoryrepo.save(category); }
	 */
}
