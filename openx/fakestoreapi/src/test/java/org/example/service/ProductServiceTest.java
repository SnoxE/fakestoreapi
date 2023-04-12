package org.example.service;

import org.example.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    void findProductIndex()
    {
        //given
        List<Product> products = new ArrayList<>();

        // products list
        products.add(new Product(1, 11, "Subscription", null, null, null));
        products.add(new Product(3, 20, "Burger", null, null, null));
        products.add(new Product(55, 4, "Chilli", null, null, null));
        products.add(new Product(4, 5, "Milk", null, null, null));
        products.add(new Product(46, 800, "Smartphone", null, null, null));
        products.add(new Product(10, 1500, "Laptop", null, null, null));

        //when
        int actualIndex = ProductService.findProductIndex(products, 4);
        int expectedIndex = 3;

        // then
        assertEquals(expectedIndex, actualIndex);
    }
}