package com.pavan.myretail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "productsprice")
public class ProductsPrice {

	//@Id
	private String id;
	@Field("productid")
	private String productid;
	private String price;
	private String currency;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}


	
	public ProductsPrice() {

	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public ProductsPrice(String id, String productid, String price, String currency) {
		super();
		this.id = id;
		this.productid = productid;
		this.price = price;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "ProductsPrice [id=" + id + ", productid=" + productid + ", price=" + price + ", currency="
				+ currency + "]";
	}

	

}
