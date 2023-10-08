package com.leiber.market.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.List;
@ApiModel(description = "Details about the purchase")
public class Purchase {

    @ApiModelProperty(notes = "The unique ID of the purchase")
    private int purchaseId;
    @ApiModelProperty(notes = "The unique ID of the client")
    private String clientId;
    @ApiModelProperty(notes = "The date of the purchase")
    private LocalDateTime date;
    @ApiModelProperty(notes = "The payment method of the purchase")
    private String paymentMethod;
    @ApiModelProperty(notes = "The comment of purchase")
    private String comment;
    @ApiModelProperty(notes = "The state of the purchase")
    private String state;
    @ApiModelProperty(notes = "The list of purchased items")
    private List<PurchaseItem> items;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }
}
