package org.example.Cart;

import org.example.Product.Product;
import org.example.User.User;

import java.util.List;

public class Cart
{
    int id;
    int userID;
    String date;
    List<CartProduct> cartContents;

    public Cart(int id, int userID, String date, List<CartProduct> cartContents)
    {
        this.id = id;
        this.userID = userID;
        this.date = date;
        this.cartContents = cartContents;
    }

    public int getID() { return id; }

    public int getUserID() { return userID; }

    public String getDate() { return date; }

    public List<CartProduct> getCartContents() { return cartContents; }

    @Override
    public String toString()
    {
        return "id: " + id + "\nuserID: " + userID + "\ndate: " + date + "\ncart contents: " + cartContents + "\n";
    }

    public double getCartValue(List<Product> productList)
    {
        double value = 0;

        for(CartProduct cp : cartContents)
        {
            int productIndex = Product.findProductIndex(productList, cp.productID);
            double itemValue = productList.get(productIndex).getPrice();

            value += itemValue * cp.quantity;
        }

        return value;
    }

    public static void findMaxCartValue(List<Cart> cartList, List<Product> productList, List<User> userList)
    {
        double maxValue = 0;
        double maxIndex = 0;
        String firstname = "";
        String lastname = "";

        for(Cart c : cartList)
        {
            if(c.getCartValue(productList) > maxValue)
            {
                maxValue = c.getCartValue(productList);
                maxIndex = c.getID();
                firstname = userList.get(User.findUserIndex(userList, c.getUserID())).getName().getFirstname();
                lastname = userList.get(User.findUserIndex(userList, c.getUserID())).getName().getLastname();
            }
        }

        System.out.println("Max value of a cart is: " + maxValue +
                "\nThe owner of that cart is " + firstname + " " + lastname + "\n");
    }
}
