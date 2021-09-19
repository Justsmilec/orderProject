package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private List<ProductQuantity> productQuantityList;
    private String description;
    private double totalCost;
    private Date date;


    public Order(){
        this.id = 1;
        this.productQuantityList = new ArrayList<ProductQuantity>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductQuantity> getProductQuantityList() {
        return productQuantityList;
    }

    public void setProductQuantityList(ProductQuantity productQuantityList) {
        this.productQuantityList.add(productQuantityList);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost(List<ProductQuantity> listofproducts) {
        double cost = 0;
        for(ProductQuantity product :listofproducts){
            cost = cost + (product.product.getPrice() * product.quantity);
        }
        return cost;
    }
}
