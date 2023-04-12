package org.example.model;

public record Product(int id, double price, String description, String category, String image, Rating rating) {}

//    @Override
//    public String toString()
//    {
//        return "id: " + id + "\nprice: " + price + "\ndescription: " + description +
//                "\ncategory: " + category + "\nimage: " + image + "\nrate: " + rating.rate +
//                "\ncount: " + rating.count + "\n";
//    }