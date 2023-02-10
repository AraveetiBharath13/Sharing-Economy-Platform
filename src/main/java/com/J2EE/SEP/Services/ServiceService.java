package com.J2EE.SEP.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.J2EE.SEP.Entity.Category;
//import com.J2EE.SEP.Entity.Category;
import com.J2EE.SEP.Entity.ProductEntity;
import com.J2EE.SEP.Entity.ServiceEntity;
import com.J2EE.SEP.Repository.ProductRepository;
import com.J2EE.SEP.Repository.ServiceRepo;

@Service
public class ServiceService {
	@Autowired
	ServiceRepo servicerepo;
	public void createservice(ServiceEntity service) {
		servicerepo.save(service);
	}
	
	public void removeServiceById(int id) { servicerepo.deleteById(id);}
	
	public List<ServiceEntity> getAllServices(){
		return servicerepo.findAll();
		
		
	}

	public Optional<ServiceEntity> getServiceById(int id) 
	{
		
		return servicerepo.findById(id);
	}

	
	/*
	 * public List<ProductEntity> getAllProductByCategoryId(){ return
	 * prorepo.findById(int);
	 * 
	 * 
	 * }
	 */
	 
}
