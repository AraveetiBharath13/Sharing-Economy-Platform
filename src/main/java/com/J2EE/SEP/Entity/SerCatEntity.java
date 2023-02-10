package com.J2EE.SEP.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "servicecategory")
public class SerCatEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "sercategory_id")
	private int id;
	private  String servicecategoryname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServicecategoryname() {
		return servicecategoryname;
	}
	public void setServicecategoryname(String servicecategoryname) {
		this.servicecategoryname = servicecategoryname;
	}
	@Override
	public String toString() {
		return "SerCatEntity [id=" + id + ", servicecategoryname=" + servicecategoryname + "]";
	}
	
}