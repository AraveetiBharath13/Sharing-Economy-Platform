package com.J2EE.SEP.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.J2EE.SEP.Entity.Category;
//import com.J2EE.SEP.Entity.Category;
import com.J2EE.SEP.Entity.ProductEntity;
import com.J2EE.SEP.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository prorepo;
	public void createproduct(ProductEntity product) {
		prorepo.save(product);
	}
	
	public void removeProductById(int id) { prorepo.deleteById(id);}
	
	public List<ProductEntity> getAllProduct(){
		return prorepo.findAll();
		
		
	}

	public Optional<ProductEntity> getProductById(int id) {
		
		return prorepo.findById(id);
	}

	
	/*
	 * public List<ProductEntity> getAllProductByCategoryId(){ return
	 * prorepo.findById(int);
	 * 
	 * 
	 * }
	 */
	 
}
