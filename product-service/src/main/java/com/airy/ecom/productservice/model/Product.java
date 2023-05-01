package com.airy.ecom.productservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "product_details_table")
@Data @Builder
public class Product {

	//id, name, price, imageurl, desc, category
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_image_url")
	private String imageUrl;
	
	@Column(name = "product_price")
	private double price;
	
	@Column(name = "product_description")
	private String desc;
	
	@Column(name = "product_category")
	private String category;


	public Product(Integer productId, String productName, String imageUrl, double price, String desc,
			String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.price = price;
		this.desc = desc;
		this.category = category;
	}
	
	public Product() {
		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Product product = (Product) o;
		return productId != null && Objects.equals(productId, product.productId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
