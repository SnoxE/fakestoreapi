package org.example;

import org.example.Cart.Cart;
import org.example.Cart.CartProduct;
import org.example.Product.Product;
import org.example.Product.Rating;
import org.example.User.Address;
import org.example.User.Geolocation;
import org.example.User.Name;
import org.example.User.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JSONparsing
{
    public static List<User> getUsersFromJSON(String usersURL)
    {
        List<User> userList = null;

        try
        {
            URL url = new URL(usersURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connection is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200)
            {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }
            else
            {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext())
                {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                JSONParser parse = new JSONParser();
                JSONArray dataArray = (JSONArray) parse.parse(String.valueOf(informationString));

                //Get the first JSON object in the JSON array

                userList = new ArrayList<>();

                for (Object o : dataArray)
                {
                    JSONObject object = (JSONObject) o;

                    JSONObject JSONaddress = (JSONObject) object.get("address");
                    JSONObject JSONgeolocation = (JSONObject) JSONaddress.get("geolocation");
                    JSONObject JSONName = (JSONObject) object.get("name");

                    Geolocation geolocation = new Geolocation(
                            Double.parseDouble(JSONgeolocation.get("lat").toString()),
                            Double.parseDouble(JSONgeolocation.get("long").toString())
                    );

                    Address address = new Address(
                            geolocation,
                            JSONaddress.get("city").toString(),
                            JSONaddress.get("street").toString(),
                            Integer.parseInt(JSONaddress.get("number").toString()),
                            JSONaddress.get("zipcode").toString()
                    );

                    Name name = new Name(
                            JSONName.get("firstname").toString(),
                            JSONName.get("lastname").toString()
                    );

                    User user = new User(
                            address,
                            Integer.parseInt(object.get("id").toString()),
                            object.get("email").toString(),
                            object.get("username").toString(),
                            object.get("password").toString(),
                            name,
                            object.get("phone").toString()
                    );

                    userList.add(user);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return userList;
    }

    public static List<Product> getProductsFromJSON(String productsURL)
    {
        List<Product> productList = null;

        try
        {
            URL url = new URL(productsURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connection is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200)
            {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }
            else
            {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext())
                {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                JSONParser parse = new JSONParser();
                JSONArray dataArray = (JSONArray) parse.parse(String.valueOf(informationString));

                //Get the first JSON object in the JSON array
                productList = new ArrayList<>();

                for (Object o : dataArray)
                {
                    JSONObject object = (JSONObject) o;

                    JSONObject JSONRating = (JSONObject) object.get("rating");

                    Rating rating = new Rating(
                            Double.parseDouble(JSONRating.get("rate").toString()),
                            Integer.parseInt(JSONRating.get("count").toString())
                    );

                    Product product = new Product(
                            Integer.parseInt(object.get("id").toString()),
                            Double.parseDouble(object.get("price").toString()),
                            object.get("description").toString(),
                            object.get("category").toString(),
                            object.get("image").toString(),
                            rating
                    );

                    productList.add(product);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return productList;
    }

    public static List<Cart> getCartsFromJSON(String cartsURL)
    {
        List<Cart> cartList = null;

        try
        {
            URL url = new URL(cartsURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connection is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200)
            {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }
            else
            {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext())
                {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                JSONParser parse = new JSONParser();
                JSONArray dataArray = (JSONArray) parse.parse(String.valueOf(informationString));

                //Get the first JSON object in the JSON array

                cartList = new ArrayList<>();

                for (Object o : dataArray)
                {
                    JSONObject object = (JSONObject) o;
                    JSONArray JSONcartProduct = (JSONArray) object.get("products");

                    List<CartProduct> cartContents = new ArrayList<>();

                    for (Object o1 : JSONcartProduct)
                    {
                        JSONObject object1 = (JSONObject) o1;

                        cartContents.add(new CartProduct(
                                Integer.parseInt(object1.get("quantity").toString()),
                                Integer.parseInt(object1.get("productId").toString())
                        ));
                    }

                    Cart cart = new Cart(
                            Integer.parseInt(object.get("id").toString()),
                            Integer.parseInt(object.get("userId").toString()),
                            object.get("date").toString(),
                            cartContents
                    );

                    cartList.add(cart);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return cartList;
    }
}
