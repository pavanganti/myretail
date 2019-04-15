package com.pavan.myretail.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductItem {
	
	public String tcin;
	public String item_state;
	
	public ProductItem() {
		
	}
	
	public String getProductid() {
		return tcin;
	}
	
	public void setProductid(String productid) {
		this.tcin = productid;
	}
	
	public String getProductname() {
		return item_state;
	}
	
	@Override
	public String toString() {
		return "ProductInfo [productid=" + tcin + ", productname=" + item_state + "]";
	}

	public void setProductname(String productname) {
		this.item_state = productname;
	}

}
