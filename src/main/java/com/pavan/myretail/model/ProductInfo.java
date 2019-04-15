package com.pavan.myretail.model;

public class ProductInfo {
	
	private String productId;
	private String productName;
	private ProductsPrice prodPrice;
	
	public ProductInfo() {
		
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductsPrice getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(ProductsPrice prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	public ProductInfo(String productId, String productName, ProductsPrice prodPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.prodPrice = prodPrice;
	}
}
