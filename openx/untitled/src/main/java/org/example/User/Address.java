package org.example.User;

public class Address
{
    Geolocation geolocation;
    String city;
    String street;
    int number;
    String zipcode;

    public Address(Geolocation geolocation, String city, String street, int number, String zipcode)
    {
        this.geolocation = geolocation;
        this.city = city;
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
    }

    public Geolocation getGeolocation() { return geolocation; }
    public String getCity() { return city; }
    public String getStreet() { return street; }
    public int getNumber() { return number; }
    public String getZipcode() { return zipcode; }
}
