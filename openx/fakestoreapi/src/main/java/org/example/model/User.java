package org.example.model;

public record User (Address address, int id, String email, String username, String password, Name name, String phone){}