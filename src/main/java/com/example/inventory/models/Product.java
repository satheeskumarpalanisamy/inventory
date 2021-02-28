package com.example.inventory.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name="PRODUCT_ID")
	private Integer productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="UNIT_PRICE")
	private Long UnitPrice;
	
	@Column(name="DISCOUNT")
	private Long discount;
	
	@Column(name="QUANTITY")
	private Long quantity;
	
	@Column(name="UNIT_VALUE")
	private Integer unitValue;
	
	@Column(name="CREATED_AT")
	private Date createdAt;
	
	@Column(name="UPDATED_AT")
	private Date updatedAt;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="BRAND_ID")
	private Integer brandId;
	
	@Column(name="BRAND_NAME")
	private String brandName;

	protected Product() {

	}

	public Product(Integer productId, String productName, Long unitPrice, Long discount, Long quantity,
			Integer unitValue, Date createdAt, Date updatedAt, String content, Integer brandId, String brandName) {
		super();
		this.productId = productId;
		this.productName = productName;
		UnitPrice = unitPrice;
		this.discount = discount;
		this.quantity = quantity;
		this.unitValue = unitValue;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.content = content;
		this.brandId = brandId;
		this.brandName = brandName;
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

	public Long getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		UnitPrice = unitPrice;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Integer getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(Integer unitValue) {
		this.unitValue = unitValue;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", UnitPrice=" + UnitPrice
				+ ", discount=" + discount + ", quantity=" + quantity + ", unitValue=" + unitValue + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", content=" + content + ", brandId=" + brandId
				+ ", brandName=" + brandName + "]";
	}

	
}
