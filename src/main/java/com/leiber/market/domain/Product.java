package com.leiber.market.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
@ApiModel(description = "Details about the product")
public class Product {

    @ApiModelProperty(notes = "The unique ID of the product")
    private int productId;
    @ApiModelProperty(notes = "The name of the product")
    private String name;
    @ApiModelProperty(notes = "The category id of the product")
    private int categoryId;
    @ApiModelProperty(notes = "The price of the product")
    private BigDecimal price;
    @ApiModelProperty(notes = "The quantity of products")
    private int stock;
    @ApiModelProperty(notes = "The state of the product")
    private boolean active;
    @ApiModelProperty(notes = "The type category of the product")
    private Category category;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
