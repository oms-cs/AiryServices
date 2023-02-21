package com.algodrop.ecom.productservice.model.dto;

import com.algodrop.ecom.productservice.model.Product;

public class ProductReqRes {
	
	private Integer productId;
	private String productName;
	private String imageUrl;
	private double price;
	private String desc;
	private String category;
	
	
	public ProductReqRes(Integer productId, String productName, String imageUrl, double price, String desc,
			String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.price = price;
		this.desc = desc;
		this.category = category;
	}  
	
	
	public ProductReqRes(Product product) {
		this.productId = product.getProductId();
		this.productName = product.getProductName();
		this.imageUrl = product.getImageUrl();
		this.price = product.getPrice();
		this.desc = product.getDesc();
		this.category = product.getCategory();
	}
	
	public ProductReqRes() {
		
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}  
	
}
