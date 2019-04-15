package com.pavan.myretail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.myretail.model.ProductInfo;
import com.pavan.myretail.service.ProductsInfoService;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsInfoService productsSrvc;

	
	
	@RequestMapping(value = "/{productid}", method = RequestMethod.GET)
	public ProductInfo getProductById(@PathVariable String productid){
		
		ProductInfo productInfo = null;
		productInfo = productsSrvc.getProductInfo(productid);
		
		return productInfo;
	}

	


}
