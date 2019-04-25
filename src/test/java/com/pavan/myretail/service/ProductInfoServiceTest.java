package com.pavan.myretail.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pavan.myretail.model.CurrentPrice;
import com.pavan.myretail.model.ProductsPrice;
import com.pavan.myretail.repositories.ProductsPriceRepository;

@RunWith(SpringRunner.class)
public class ProductInfoServiceTest {
	
	@TestConfiguration
	static class ProductsInfoServiceTestConfiguration{
		@Bean
		public ProductsInfoService productsInfoService() {
			return new ProductsInfoService();
		}
	}
	
	@Autowired
	private ProductsInfoService productsInfoService;
	
	@MockBean
	private ProductsPriceRepository currentPriceRepo;
	
	@Before
	public void setUp() {
		CurrentPrice currentPrice = new CurrentPrice(11, "USD");
		ProductsPrice productPrice = new ProductsPrice(12345, currentPrice);
		
		Mockito.when(currentPriceRepo.findByid(12345)).thenReturn(productPrice);
	}
	
	@Test
	public void whenValidProductId_thenProductCurrentPriceBeFound() {
		CurrentPrice currentPrice = new CurrentPrice(11, "USD");
		ProductsPrice expectedPrice = new ProductsPrice(12345, currentPrice);
		ProductsPrice foundProductPrice = currentPriceRepo.findByid(12345);
		assertEquals(expectedPrice.getProductid(), foundProductPrice.getProductid());
		assertEquals(expectedPrice.getCurrentPrice().getCurrenycode(), foundProductPrice.getCurrentPrice().getCurrenycode());
		assertEquals(expectedPrice.getCurrentPrice().getCurrent_price(), foundProductPrice.getCurrentPrice().getCurrent_price(), 0);
	}
	
	@Test
	public void whenInValidProductId_thenProductCurrentPriceNotFound() {
		Mockito.when(currentPriceRepo.findByid(1234567)).thenReturn(null);
		
		ProductsPrice foundProductPrice = currentPriceRepo.findByid(1234567);
		assertEquals(null, foundProductPrice);
	}

}
