package com.J2EE.SEP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;




@Entity
@Table(name= "servicesList")
public class ServiceEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	
	
	  @ManyToOne(fetch = FetchType.LAZY)
	  
	  @JoinColumn(name = "sercategory_id", referencedColumnName="sercategory_id" )
	  private SerCatEntity service;
	 
	 
		/*
		 * @ManyToOne(fetch= FetchType.LAZY)
		 * 
		 * @JoinColumn(name="vendorId", referencedColumnName="vendor_id") private
		 * VendorRegistration vendorId;
		 */
	 
	private double price;
	private double quantity;
	private String description;
	private String imageName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SerCatEntity getService() {
		return service;
	}
	public void setService(SerCatEntity service) {
		this.service = service;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Override
	public String toString() {
		return "ServiceEntity [id=" + id + ", name=" + name + ", service=" + service + ", price=" + price
				+ ", quantity=" + quantity + ", description=" + description + ", imageName=" + imageName + "]";
	}
	
}
