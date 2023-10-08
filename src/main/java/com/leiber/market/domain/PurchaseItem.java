package com.leiber.market.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the purchased items")
public class PurchaseItem {
    @ApiModelProperty(notes = "The unique ID of the purchased product")
    private int productId;
    @ApiModelProperty(notes = "The number of the products purchased")
    private int quantity;
    @ApiModelProperty(notes = "The total purchase")
    private double total;
    @ApiModelProperty(notes = "The state of the purchase")
    private boolean active;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
