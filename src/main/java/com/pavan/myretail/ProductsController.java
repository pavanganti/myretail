package com.pavan.myretail;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.myretail.model.ProductsPrice;
import com.pavan.myretail.repositories.ProductsPriceRepository;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsPriceRepository prodPriceRepo;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ProductsPrice> getAllProducts(){
		return prodPriceRepo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProductsPrice getProductById(@PathVariable String id){
		return prodPriceRepo.findByid(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyProductById(@PathVariable("id") String id, @Valid @RequestBody ProductsPrice productPrice) {
		productPrice.setId(id);
		prodPriceRepo.save(productPrice);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ProductsPrice createProductPrice(@Valid @RequestBody ProductsPrice productPrice) {
		prodPriceRepo.save(productPrice);
		return productPrice;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProductPrice(@PathVariable String id) {
		prodPriceRepo.delete(prodPriceRepo.findByid(id));
	}


}
