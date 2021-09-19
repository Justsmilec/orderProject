package com.company;

import java.util.HashMap;

public class Warehouse {
    public static HashMap<String,ProductQuantity> storage = new HashMap<String,ProductQuantity>();

    public static ProductQuantity getProductQuantity(String description) {
        if(storage.containsKey(description)) {
            return storage.get(description);
        }
        return null;
    }

    public static void addProductQuantity(Product product,int qunatity){
        storage.put(product.getDescription(),new ProductQuantity(product,qunatity));
    }
}
