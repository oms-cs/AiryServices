package com.airy.ecom.productservice.controller;

import java.util.List;

import com.airy.ecom.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airy.ecom.productservice.model.dto.ProductReqRes;
import com.airy.ecom.productservice.services.ProductsService;

@RequestMapping("api/v1/product")
@RestController
public class ProductsController {
	
	/*
	 * This is a Product Service Controller which Provides Following Endpoints
	 */
	
	  // "/api/v1/product/products" - get a list of Products to show on listing Screen
	  // "/api/v1/product/add-product" - to add product to 
	  // "/api/v1/product/{product_name}" - get a single product details of name product_name
	  // "/api/v1/product/{category_name}" - get all products of category_name category
	
	@Autowired
	private final ProductsService productsService;
	
	
	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}
	 
	
	@GetMapping("/products")
	public List<ProductReqRes> listAllProducts() {
		//returns List of Products Fetched from db
		return productsService.getAllProducts();
	}
	
	@PostMapping("/add-product")
	public ResponseEntity<?> addProducts(@RequestBody ProductReqRes productReqRes){
		productsService.addProducts(productReqRes);
		return ResponseEntity.ok(productReqRes.getProductName());
	}
	
	@GetMapping("/{productName}")
	public Product getProductByName(@PathVariable String productName) {
		return productsService.getProductByName(productName);
	}
	
	@GetMapping("/category/{category}")
	public List<ProductReqRes> getProductsByCategory(@PathVariable String category){
		return productsService.getProductsByCategory(category);
	}
	
	
}
