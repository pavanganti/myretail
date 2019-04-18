package com.pavan.myretail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "productsprice")
public class ProductsPrice {

	private String id;
	public String getId() {
		return id;
	}

	/*
	 * public void setId(String id) { this.id = id; }
	 */

	@Id
	private String productid;
	private CurrentPrice currentPrice;
	

	
	@Override
	public String toString() {
		return "ProductsPrice [id=" + id + ", productid=" + productid + ", currentPrice=" + currentPrice + "]";
	}

	public ProductsPrice(String id, String productid, CurrentPrice currentPrice) {
		super();
		//this.id = id;
		//this.productid = productid;
		this.currentPrice = currentPrice;
	}

	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getProductid() {
		return productid;
	}

	/*
	 * public void setProductid(String productid) { this.productid = productid; }
	 */


	
	public ProductsPrice() {

	}

	
	

	

	

	

}
