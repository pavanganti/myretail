package com.pavan.myretail.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pavan.myretail.model.ProductsPrice;

public interface ProductsPriceRepository extends MongoRepository<ProductsPrice, String> {
	
	ProductsPrice findByid(String productid);

}
