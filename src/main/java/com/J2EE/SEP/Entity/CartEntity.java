package com.J2EE.SEP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class CartEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="name")
	private ProductEntity name;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private CustomerRegistration customerId;

	public CartEntity() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductEntity getName() {
		return name;
	}

	public void setName(ProductEntity name) {
		this.name = name;
	}

	public CustomerRegistration getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerRegistration customerId) {
		this.customerId = customerId;
	}
	
	
	
	

}
