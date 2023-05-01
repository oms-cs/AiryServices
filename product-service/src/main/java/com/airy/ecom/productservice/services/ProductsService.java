package com.airy.ecom.productservice.services;

import java.util.List;

import com.airy.ecom.productservice.model.dto.ProductReqRes;
import com.airy.ecom.productservice.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airy.ecom.productservice.model.Product;

@Service
public class ProductsService {
	
	@Autowired
	private final ProductsRepository productsRepository;
	
	public ProductsService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	
	
	//returns all the products listed 
	public List<ProductReqRes> getAllProducts(){
		 List<ProductReqRes> products = productsRepository.findAll().stream()
				 													.map(ProductReqRes::new)
				 													.toList();
		 return products;
	}
	
	//adds Product for Sell Listing
	public void addProducts(ProductReqRes productReqRes) {
		productsRepository.save(mapToProduct(productReqRes));
	}
	

	public Product getProductByName(String productName){
		return productsRepository.findByProductName(productName).get();
	}


	public List<ProductReqRes> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return productsRepository.findByCategory(category).stream()
																  .map(ProductReqRes::new)
																  .toList();
	}
	
	
	
	
	
	
	
	public Product mapToProduct(ProductReqRes productReqRes) {
		Product product = new Product();		
		product.setProductName(productReqRes.getProductName());
		product.setImageUrl(productReqRes.getImageUrl());
		product.setDesc(productReqRes.getDesc());
		product.setPrice(productReqRes.getPrice());
		product.setCategory(productReqRes.getCategory());		
		return product;
	}

}
