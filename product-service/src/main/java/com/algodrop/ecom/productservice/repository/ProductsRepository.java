package com.algodrop.ecom.productservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algodrop.ecom.productservice.model.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer>{
	
	public Optional<Product> findByProductName(String productName);
	
	public List<Product> findByCategory(String categoryName);
}
