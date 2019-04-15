package com.pavan.myretail.model;

public class CurrentPrice {
	
	private float current_price;
	private String currenycode;
	public float getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(float current_price) {
		this.current_price = current_price;
	}
	public String getCurrenycode() {
		return currenycode;
	}
	public void setCurrenycode(String currenycode) {
		this.currenycode = currenycode;
	}
	public CurrentPrice(float current_price, String currenycode) {
		super();
		this.current_price = current_price;
		this.currenycode = currenycode;
	}
	public CurrentPrice() {
		
	}
	

}
