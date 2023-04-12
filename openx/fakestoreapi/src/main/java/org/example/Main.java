package org.example;

import org.example.Cart.*;
import org.example.Product.*;
import org.example.User.*;
import java.util.*;

import static org.example.JSONparsing.*;

public class Main
{
    public static void main(String[] args)
    {
        String usersURL = "https://fakestoreapi.com/users";
        String productsURL = "https://fakestoreapi.com/products";
        String cartsURL = "https://fakestoreapi.com/carts";

        List<User> userList = getUsersFromJSON(usersURL);
        List<Product> productList = getProductsFromJSON(productsURL);
        List<Cart> cartList = getCartsFromJSON(cartsURL);

        Map<String, Double> categoryValue = new HashMap<>();

        for(Product p : productList)
        {
            if(categoryValue.containsKey(p.getCategory()))
            {
                Double oldValue = categoryValue.get(p.getCategory());
                categoryValue.replace(
                        p.getCategory(),
                        oldValue,
                        oldValue + p.getPrice()
                        );
            }
            else
                categoryValue.put(p.getCategory(), p.getPrice());
        }

//        System.out.println("All categories and their values are: " + categoryValue.entrySet() + "\n");
        Cart.findMaxCartValue(cartList, productList, userList);

        for(Object o : categoryValue.keySet())
            System.out.println("Value of " + o + " equals " + categoryValue.get(o.toString()));

        User.usersFurthestApart(userList);
    }
}