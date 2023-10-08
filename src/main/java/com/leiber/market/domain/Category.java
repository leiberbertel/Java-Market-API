package com.leiber.market.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the category")
public class Category {
    @ApiModelProperty(notes = "The unique ID of the category")
    private int categoryId;
    @ApiModelProperty(notes = "The ID category of product")
    private String category;
    @ApiModelProperty(notes = "The state of the category")
    private boolean active;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
