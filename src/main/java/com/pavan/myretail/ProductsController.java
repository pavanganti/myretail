package com.pavan.myretail;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.myretail.exception.ProductIdNotFoundException;
import com.pavan.myretail.model.ProductInfo;
import com.pavan.myretail.service.ProductsInfoService;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsInfoService productsSrvc;

	
	
	@RequestMapping(value = "/{productid}", method = RequestMethod.GET)
	public ProductInfo getProductById(@PathVariable int productid) throws ProductIdNotFoundException{
		
		ProductInfo productInfo = null;
		productInfo = productsSrvc.getProductInfo(productid);
		
		return productInfo;
	}
	
	@RequestMapping(value = "/{productid}", method = RequestMethod.PUT)
	public ProductInfo updateProductCurrentPrice(@PathVariable int productid, @Valid @RequestBody ProductInfo productInfo) throws ProductIdNotFoundException{
		
		ProductInfo updatedProductInfo = productsSrvc.updateCurrentPrice(productid, productInfo);
		
		return productInfo;
	}

	


}
