package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceTest {

    @Test
    void getCartValueTest()
    {
        // given
        List<Product> products = new ArrayList<>();

        int id1 = 1234;
        int userID1 = 5678;
        String date1 = "2023-04-12";

        List<CartProduct> cartProducts1 = new ArrayList<>();
        cartProducts1.add(new CartProduct(1, 2));
        cartProducts1.add(new CartProduct(2, 1));

        Cart testCart = new Cart(id1, userID1, date1, cartProducts1);

        products.add(new Product(1, 10, null, null, null, null));
        products.add(new Product(2, 11, null, null, null, null));

        // when
        double actualPrice = CartService.getCartValue(testCart, products);
        double expectedPrice = 31;

        // then
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void findMaxCartValue()
    {
        // given
        List<Cart> carts = new ArrayList<>();
        List<Product> products = new ArrayList<>();

            // Example cart 1
        List<CartProduct> cartProducts1 = new ArrayList<>();
        cartProducts1.add(new CartProduct(1, 2));
        cartProducts1.add(new CartProduct(2, 1));

            // Example cart 2
        List<CartProduct> cartProducts2 = new ArrayList<>();
        cartProducts2.add(new CartProduct(2, 1));
        cartProducts2.add(new CartProduct(4, 2));
        cartProducts2.add(new CartProduct(6, 1));

            // Example cart 3
        List<CartProduct> cartProducts3 = new ArrayList<>(); // 2333
        cartProducts3.add(new CartProduct(1,3));
        cartProducts3.add(new CartProduct(5,1));
        cartProducts3.add(new CartProduct(6,1));

            // cart list
        carts.add(new Cart(1234, 23, "2023-04-12", cartProducts1));
        carts.add(new Cart(5678, 11, "2023-04-12", cartProducts2));
        carts.add(new Cart(4321, 30, "2023-04-12", cartProducts3));

            // products list
        products.add(new Product(1, 11, "Subscription", null, null, null));
        products.add(new Product(2, 20, "Burger", null, null, null));
        products.add(new Product(3, 4, "Bread", null, null, null));
        products.add(new Product(4, 5, "Milk", null, null, null));
        products.add(new Product(5, 800, "Smartphone", null, null, null));
        products.add(new Product(6, 1500, "Laptop", null, null, null));

            // users list
        Geolocation g = new Geolocation(3, -4);
        Geolocation g1 = new Geolocation(0, 0);
        Geolocation g2 = new Geolocation(6, -8);

        Address a = new Address(g, "San Francisco", "Warriors Way", 30, "94158");
        Address a1 = new Address(g1, "San Francisco", "Warriors Way", 11, "94158");
        Address a2 = new Address(g2, "San Francisco", "Warriors Way", 23, "94158");

        Name n = new Name("Stephen", "Curry");
        Name n1 = new Name("Klay", "Thompson");
        Name n2 = new Name("Draymond", "Green");

        User u = new User(a, 30, "warriors@gmail.com", "username", "password", n, "123456789");
        User u1 = new User(a1, 11, "warriors@gmail.com", "username", "password", n1, "123456789");
        User u2 = new User(a2, 23, "warriors@gmail.com", "username", "password", n2, "123456789");

        List<User> users = new ArrayList<>();
        users.add(u);
        users.add(u1);
        users.add(u2);

        // when
        Cart actualCart = CartService.findMaxCartValue(carts, products, users);
        Cart expectedCart = carts.get(2);

        // then
        assertEquals(expectedCart, actualCart);
    }
}