package com.pavan.myretail.service;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.myretail.exception.ProductIdNotFoundException;
import com.pavan.myretail.model.ProductInfo;
import com.pavan.myretail.model.ProductsPrice;
import com.pavan.myretail.repositories.ProductsPriceRepository;

@Service
public class ProductsInfoService {

	@Autowired
	private ProductsPriceRepository prodPriceRepo;

	public ProductInfo getProductInfo(int productid) throws ProductIdNotFoundException {

		ProductInfo prodInfo = new ProductInfo();
		String productDescription = "";
		//get the productname from the api
		try {
			productDescription = getProductName(productid);
		}
		catch(ProductIdNotFoundException pex) {
			productDescription = "Default product descrption";
		}
		prodInfo.setProductId(productid);
		prodInfo.setProductName(productDescription);
		ProductsPrice productsPrice = prodPriceRepo.findByid(productid);
		if(productsPrice == null) {
			throw new ProductIdNotFoundException("Product not in DB");
		}
		prodInfo.setCurrentPrice(productsPrice.getCurrentPrice());
		return prodInfo;
	}

	public String getProductName(int productid) throws ProductIdNotFoundException {
		RestTemplate restTemplate = new RestTemplate();
		String prodDescription = "";
		try {
			String restapiurl1 = "https://redsky.target.com/v2/pdp/tcin/";
			String restapiurl2 = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
			ResponseEntity<String> response = restTemplate.getForEntity(restapiurl1+productid+restapiurl2, String.class);

			
			ObjectMapper jsonMapper = new ObjectMapper();
			JsonNode productNode = jsonMapper.readTree(response.getBody());
			JsonNode productInfo = productNode.get("product");
			JsonNode itemInfo = productInfo.get("item");
			JsonNode productId = itemInfo.get("tcin");
			JsonNode productDesc = itemInfo.get("product_description");
			JsonNode productDescTitle = productDesc.get("title");
			prodDescription = productDescTitle.toString();

		}
		catch(IOException ioe) {
			throw new ProductIdNotFoundException("Product Description not found");
		}
		catch(HttpClientErrorException hex) {
			throw new ProductIdNotFoundException("Product Description not found");
		}
		return prodDescription;
	}

	public ProductInfo updateCurrentPrice(int productid, @Valid ProductInfo productInfo) throws ProductIdNotFoundException {
		// TODO Auto-generated method stub
		ProductInfo existingProduct = getProductInfo(productid);
		ProductsPrice tobeUpdatePrice = new ProductsPrice();
		if(existingProduct == null) {
			throw new ProductIdNotFoundException("The given product is not present in DB.");
		}
		else {
			if(existingProduct.getProductId()!= productInfo.getProductId()){
				throw new ProductIdNotFoundException("The productid's in the request body to that of the product id in the DB");
			}
			else {
				tobeUpdatePrice.setCurrentPrice(productInfo.getCurrentPrice());
				tobeUpdatePrice.setProductid(productid);
				tobeUpdatePrice = prodPriceRepo.save(tobeUpdatePrice);
			}
		}
		existingProduct.setCurrentPrice(tobeUpdatePrice.getCurrentPrice());
		return existingProduct;
	}

}
