package org.example.model;
public record Address(Geolocation geolocation, String city, String street, int number, String zipcode) {}
