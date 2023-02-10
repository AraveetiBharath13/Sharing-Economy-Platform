package com.J2EE.SEP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name= "productsList")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "procategory_id", referencedColumnName="procategory_id" )
	  private Category category;
	 
		/*
		 * @ManyToOne(fetch= FetchType.LAZY)
		 * 
		 * @JoinColumn(name="vendorId", referencedColumnName="vendor_id") private
		 * VendorRegistration vendorId;
		 */
	 
	private double price;
	private double weight;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
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
		return "ProductEntity [id=" + id + ", name=" + name + ", price=" + price + ", weight=" + weight
				+ ", description=" + description + ", imageName=" + imageName + "]";
	}
	
	
	
	

}
