package com.J2EE.SEP.Global;

import java.util.ArrayList;
import java.util.List;

import com.J2EE.SEP.Entity.ProductEntity;

public class GlobalData {
	public static List<ProductEntity> cart;
	
	static {
		
		cart= new ArrayList<ProductEntity>();
	}

}
