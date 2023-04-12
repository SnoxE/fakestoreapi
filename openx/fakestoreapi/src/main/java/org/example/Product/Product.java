package org.example.Product;

import java.util.List;

public class Product
{
    int id;
    double price;
    String description;
    String category;
    String image;
    Rating rating;

    public Product(int id, double price, String description, String category, String image, Rating rating)
    {
        this.id = id;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }

    // getters
    public int getID() { return id; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getImage() { return image; }
    public Rating getRating() { return rating; }


    // overridden methods
    @Override
    public String toString()
    {
        return "id: " + id + "\nprice: " + price + "\ndescription: " + description +
                "\ncategory: " + category + "\nimage: " + image + "\nrate: " + rating.rate +
                "\ncount: " + rating.count + "\n";
    }

    // static methods
    public static int findProductIndex(List<Product> productList, int id)
    {
        int index = -1; //starting from -1 in order to differentiate between index not found and index found at 0
        int iter = -1;
        for(Product p : productList)
        {
            if(p.getID() == id)
            {
                index = ++iter;
                break;
            }

            iter++;
        }

        return index;
    }
}
