package com.airy.ecom.productservice.model;

import com.airy.ecom.productservice.model.dto.ProductReqRes;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.Objects;


@Document(value = "product_details_table")
@Data @Builder
public class Product {

	//id, name, price, imageurl, desc, category

	@Field(name = "product_id")
	@MongoId
	private String productId;
	
	@Field(name = "product_name")
	@TextIndexed(weight = 5)
	private String productName;
	
	@Field(name = "product_image_url")
	private List<String> imageUrl;
	
	@Field(name = "product_price")
	private Double price;
	
	@Field(name = "product_description")
	@TextIndexed(weight = 4)
	private String desc;
	
	@Field(name = "product_category")
	private String category;

	@Field(name = "product_attributes")
	@TextIndexed(weight = 4)
	private List<ProductAttributes> attributes;


	//popularity of Product
	//reviews for product


	public Product(String productId, String productName, List<String> imageUrl, double price, String desc,
			String category, List<ProductAttributes> attributes) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.price = price;
		this.desc = desc;
		this.category = category;
		this.attributes = attributes;
	}
	
	public Product() {
	}

	public Product(ProductReqRes product) {
		this.productId = product.getProductId();
		this.productName = product.getProductName();
		this.imageUrl = product.getImageUrl();
		this.price = product.getPrice();
		this.desc = product.getDesc();
		this.category = product.getCategory();
		this.attributes = product.getAttributes();
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
