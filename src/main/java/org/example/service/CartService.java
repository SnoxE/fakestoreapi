package org.example.service;

import org.example.model.Cart;
import org.example.model.CartProduct;
import org.example.model.Product;
import org.example.model.User;

import java.util.List;

public class CartService
{
    public static double getCartValue(Cart cart, List<Product> productList)
    {
        double value = 0;

        for(CartProduct cartProduct : cart.cartProducts())
        {
            int productIndex = ProductService.findProductIndex(productList, cartProduct.productID());
            double itemValue = productList.get(productIndex).price();

            value += itemValue * cartProduct.quantity();
        }

        return value;
    }

    public static Cart findMaxCartValue(List<Cart> cartList, List<Product> productList, List<User> userList)
    {
        double maxValue = 0;
        String firstname = "";
        String lastname = "";
        Cart maxCart = cartList.get(0);

        for(Cart cart : cartList)
        {
            if(getCartValue(cart, productList) > maxValue)
            {
                maxValue = getCartValue(cart, productList);
                firstname = userList.get(UserService.findUserIndex(userList, cart.userID())).name().firstname();
                lastname = userList.get(UserService.findUserIndex(userList, cart.userID())).name().lastname();
                maxCart = cart;
            }
        }

        System.out.println("Max value of a cart is: " + maxValue +
                "\nThe owner of that cart is " + firstname + " " + lastname + "\n");

        return maxCart;
    }
}
