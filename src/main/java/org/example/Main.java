package org.example;

import org.example.model.Cart;
import org.example.model.Product;
import org.example.model.User;
import org.example.repository.DataRepository;
import org.example.service.CartService;
import org.example.service.UserService;

import java.util.*;

public class Main
{
    private static final String USERS_URL = "https://fakestoreapi.com/users";
    private static final String PRODUCTS_URL = "https://fakestoreapi.com/products";
    private static final String CARTS_URL = "https://fakestoreapi.com/carts";

    public static void main(String[] args)
    {

        // task1
        List<User> userList = DataRepository.getUsersFromJSON(USERS_URL);
        List<Product> productList = DataRepository.getProductsFromJSON(PRODUCTS_URL);
        List<Cart> cartList = DataRepository.getCartsFromJSON(CARTS_URL);

        // task2
        Map<String, Double> categoryValue = new HashMap<>();

        for(Product p : productList)
        {
            if(categoryValue.containsKey(p.category()))
            {
                Double oldValue = categoryValue.get(p.category());
                categoryValue.replace(
                        p.category(),
                        oldValue,
                        oldValue + p.price()
                        );
            }
            else
                categoryValue.put(p.category(), p.price());
        }

        System.out.println("Task 2\nAll categories and their values are: ");
        for(Object object : categoryValue.keySet())
            System.out.println("Value of " + object + " equals " + categoryValue.get(object.toString()));
        System.out.println();

        // task3
        System.out.println("Task3");
        CartService.findMaxCartValue(cartList, productList, userList);

        // task4
        System.out.println("Task4");
        System.out.println(UserService.usersFurthestApart(userList));
    }
}