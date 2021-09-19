package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class OrderTest {

    public static void main(String[] args) {

        String selected = "";
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        Product product1 = new Product("product1","product1",10,2020,"shume","processing");
        Product product2 = new Product("product2","product2",10.5,2020,"shume","processing");
        Product product3 = new Product("product3","product3",20,2020,"shume","processing");
        Product product4 = new Product("product4","product4",5,2020,"shume","processing");
        Product product5 = new Product("product5","product5",9,2020,"shume","processing");
        Warehouse.addProductQuantity(product1,2);
        Warehouse.addProductQuantity(product2,6);
        Warehouse.addProductQuantity(product3,23);
        Warehouse.addProductQuantity(product4,2);
        Warehouse.addProductQuantity(product5,8);

        //List of product of the customer
        List<ProductQuantity> productsOfCustomer = new ArrayList<ProductQuantity>();

        System.out.println("Deshironi te merrni nje product? (y/n)");
        selected = myObj.next();
        Order order = new Order();
        while(selected.equals("y")){
            order.setId(1);
            System.out.println("Jepni description e produktit: ");
            String description = "";
            description = myObj.next();
            if(Warehouse.getProductQuantity(description) == null) {
                System.out.println("Product with this description does not exist");

            } else {
                order.setProductQuantityList(Warehouse.getProductQuantity(description));
            }
            System.out.println("Would you like to continue? (y/n)");
            selected = myObj.next();
        }
        order.setDate(new Date());
        order.setTotalCost(order.getCost(order.getProductQuantityList()));
        order.setDescription("PUSHIME");
        printOrder(order);
        List<ProductQuantity> sortedByDescription = new ArrayList<ProductQuantity>(order.getProductQuantityList());
        Collections.sort(sortedByDescription, new Comparator<ProductQuantity>() {
            public int compare(ProductQuantity p1, ProductQuantity p2) {
                return String.valueOf(p1.product.getDescription()).compareTo(p2.product.getDescription());
            }
        });
        for(ProductQuantity product:sortedByDescription) {
            System.out.println("Description: "+ product.product.getDescription() + " , Quantity: "+ product.quantity + " , Cost: "+ product.product.getPrice());
        }
    }

    public static void printOrder(Order order){
        try {
            FileOutputStream f = new FileOutputStream(new File("order.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(order);
            o.close();
            f.close();
        } catch (IOException e) {
            System.out.println("An error occurred."+ e);
            e.printStackTrace();
        }
    }
}
