package com.pavan.myretail.service;

import java.io.IOException;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.myretail.model.ProductInfo;
import com.pavan.myretail.model.ProductsPrice;
import com.pavan.myretail.repositories.ProductsPriceRepository;

@Service
public class ProductsInfoService {
	
	
	private ProductsPriceRepository prodPriceRepo;

	public ProductInfo getProductInfo(String productid) {

		ProductInfo prodInfo = new ProductInfo();
		//get the productname from the api
		String productDescription = getProductName(productid);
		prodInfo.setProductId(productid);
		prodInfo.setProductName(productDescription);
		ProductsPrice productsPrice = prodPriceRepo.findByid(productid);
		prodInfo.setProdPrice(productsPrice);
		return prodInfo;
	}

	public String getProductName(String productid) {
		RestTemplate restTemplate = new RestTemplate();
		String prodDescription = "";
		try {
			String restapiurl1 = "https://redsky.target.com/v2/pdp/tcin/";
			String restapiurl2 = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
			ResponseEntity<String> response = restTemplate.getForEntity(restapiurl1+productid+restapiurl2, String.class);

			System.out.println("Product Info is: "+response.getBody());
			System.out.println("Product Status code is: "+response.getStatusCode());

			ObjectMapper jsonMapper = new ObjectMapper();
			JsonNode productNode = jsonMapper.readTree(response.getBody());
			JsonNode productInfo = productNode.get("product");
			System.out.println("productid is: "+productInfo.toString());
			JsonNode itemInfo = productInfo.get("item");
			System.out.println("itemInfo is: "+itemInfo.toString());
			JsonNode productId = itemInfo.get("tcin");
			System.out.println("productId is: "+productId.toString());
			JsonNode productDesc = itemInfo.get("product_description");
			JsonNode productDescTitle = productDesc.get("title");
			System.out.println("Product description is: "+productDescTitle.toString());
			prodDescription = productDescTitle.toString();

		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return prodDescription;
	}

}
