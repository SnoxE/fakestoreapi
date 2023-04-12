package org.example.service;

import org.example.model.Product;

import java.util.List;

public class ProductService
{
    public static int findProductIndex(List<Product> productList, int id) {
        int index = -1; //starting from -1 in order to differentiate between index not found and index found at 0
        int iter = -1;
        for(Product p : productList)
        {
            if(p.id() == id)
            {
                index = ++iter;
                break;
            }

            iter++;
        }

        return index;
    }
}
