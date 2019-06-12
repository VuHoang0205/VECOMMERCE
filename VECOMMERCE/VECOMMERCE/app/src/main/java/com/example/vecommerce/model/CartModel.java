package com.example.vecommerce.model;

public class CartModel {
    public static final int CARD_ITEM = 0;
    public static final int TOTAL_AMOUNT = 1;

    private int type;

    private int prductImage;
    private String productTitle;
    private int feeCoupen;
    private String productPrice;
    private String cuttedPrice;
    private int quantity;
    private int offersApplies;
    private int coupenApplies;

    public CartModel() {
    }

    public CartModel(int type, int prductImage, String productTitle, int feeCoupen, String productPrice, String cuttedPrice, int quantity, int offersApplies, int coupenApplies) {
        this.type = type;
        this.prductImage = prductImage;
        this.productTitle = productTitle;
        this.feeCoupen = feeCoupen;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.quantity = quantity;
        this.offersApplies = offersApplies;
        this.coupenApplies = coupenApplies;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrductImage() {
        return prductImage;
    }

    public void setPrductImage(int prductImage) {
        this.prductImage = prductImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFeeCoupen() {
        return feeCoupen;
    }

    public void setFeeCoupen(int feeCoupen) {
        this.feeCoupen = feeCoupen;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOffersApplies() {
        return offersApplies;
    }

    public void setOffersApplies(int offersApplies) {
        this.offersApplies = offersApplies;
    }

    public int getCoupenApplies() {
        return coupenApplies;
    }

    public void setCoupenApplies(int coupenApplies) {
        this.coupenApplies = coupenApplies;
    }

    private String totalItem;
    private String totalAmount;
    private String deliveryPrice;
    private String saveAmount;

    public CartModel(int type, String totalItem, String totalAmount, String deliveryPrice, String saveAmount) {
        this.type = type;
        this.totalItem = totalItem;
        this.totalAmount = totalAmount;
        this.deliveryPrice = deliveryPrice;
        this.saveAmount = saveAmount;
    }

    public String getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(String totalItem) {
        this.totalItem = totalItem;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getSaveAmount() {
        return saveAmount;
    }

    public void setSaveAmount(String saveAmount) {
        this.saveAmount = saveAmount;
    }
}
