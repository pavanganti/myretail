package com.pavan.myretail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "productsprice")
public class ProductsPrice {

	

	@Id
	@JsonIgnore
	@JsonProperty("productid")
	private int id;
	private CurrentPrice currentPrice;

	public ProductsPrice(int productid, CurrentPrice currentPrice) {
		super();
		//this.id = id;
		this.id = productid;
		this.currentPrice = currentPrice;
	}

	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}

	@JsonIgnore
	public int getProductid() {
		return id;
	}

	@JsonIgnore
	public void setProductid(int productid) { 
		this.id = productid; 
	}
	 
	public ProductsPrice() {

	}

	@Override
	public String toString() {
		return "ProductsPrice [productid=" + id + ", currentPrice=" + currentPrice + "]";
	}


}
