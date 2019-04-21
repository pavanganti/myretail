package com.pavan.myretail.model;

public class ProductInfo {
	
	private int productId;
	private String productName;
	private CurrentPrice currentPrice;
	
	public ProductInfo() {
		
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}

	public ProductInfo(int productId, String productName, CurrentPrice currentPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.currentPrice = currentPrice;
	}

	@Override
	public String toString() {
		return "ProductInfo [productId=" + productId + ", productName=" + productName + ", currentPrice=" + currentPrice
				+ "]";
	}
	
	
	
}
