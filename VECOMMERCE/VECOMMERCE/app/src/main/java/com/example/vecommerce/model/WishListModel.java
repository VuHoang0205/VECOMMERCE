package com.example.vecommerce.model;

public class WishListModel {

    private int productImage;
    private String productTitle;
    private String deliveryStatus;
    private int feeCoupen;
    private String rating;
    private int totalRating;
    private String productPrice;
    private String cuttedPrice;
    private String paymentPrice;

    public WishListModel() {
    }

    public WishListModel(int productImage, String productTitle, String deliveryStatus, int feeCoupen, String rating, int totalRating, String productPrice, String cuttedPrice, String paymentPrice) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.deliveryStatus = deliveryStatus;
        this.feeCoupen = feeCoupen;
        this.rating = rating;
        this.totalRating = totalRating;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.paymentPrice = paymentPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getFeeCoupen() {
        return feeCoupen;
    }

    public void setFeeCoupen(int feeCoupen) {
        this.feeCoupen = feeCoupen;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public String getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(String paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
