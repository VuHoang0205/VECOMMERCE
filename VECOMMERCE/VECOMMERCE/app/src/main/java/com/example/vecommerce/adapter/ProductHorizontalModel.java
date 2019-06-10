package com.example.vecommerce.adapter;

public class ProductHorizontalModel {

    private int productIamge;
    private String productTitle;
    private String productDescription;
    private String productPrice;

    public ProductHorizontalModel() {

    }

    public ProductHorizontalModel(int productIamge, String productTitle, String productDescription, String productPrice) {
        this.productIamge = productIamge;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public int getProductIamge() {
        return productIamge;
    }

    public void setProductIamge(int productIamge) {
        this.productIamge = productIamge;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
