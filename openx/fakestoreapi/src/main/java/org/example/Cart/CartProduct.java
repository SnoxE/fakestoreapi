package org.example.Cart;

public class CartProduct
{
    int productID;
    int quantity;

    public CartProduct(int productID, int quantity)
    {
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getProductID() { return productID; }

    public int getQuantity() { return quantity; }

    @Override
    public String toString()
    {
        return "productID: " + productID + ", quantity: " + quantity + ";";
    }


}


