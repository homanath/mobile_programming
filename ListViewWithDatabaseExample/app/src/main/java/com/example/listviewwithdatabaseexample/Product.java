package com.example.listviewwithdatabaseexample;

public class Product {
    private int pCode;
    private String pName;
    private int quantity;
    public Product() {
        pCode = 0;
        pName = "";
        quantity = 0;
    }
    public Product(int pCode, String pName, int quantity) {
        this.pCode = pCode;
        this.pName = pName;
        this.quantity = quantity;
    }
    public void setProductCode(int pCode){
        this.pCode= pCode;
    }

    public int getProductCode(){
        return pCode;
    }
    public void setProductName(String pName){
        this.pName = pName ;
    }
    public String getProductName(){
        return pName;
    }
    public void setQuantity(int qty){
        this.quantity = qty;
    }
    public int getQuantity(){
        return quantity;
    }

}
