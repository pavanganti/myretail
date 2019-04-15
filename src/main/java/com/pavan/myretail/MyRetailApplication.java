package com.pavan.myretail;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
public class MyRetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailApplication.class, args);
		
		RestTemplate restTemplate = new RestTemplate();
		try {
			String restapiurl = "https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
			ResponseEntity<String> response = restTemplate.getForEntity(restapiurl, String.class);

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
			
			
			
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		
	}

}
