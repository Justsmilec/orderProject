package com.company;

import java.io.Serializable;

public class ProductQuantity implements Serializable {
    private static final long serialVersionUID = 1L;

    public Product product;
    public int quantity;

    public ProductQuantity(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
