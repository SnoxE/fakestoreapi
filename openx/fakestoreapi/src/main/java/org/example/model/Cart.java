package org.example.model;

import java.util.List;

public record Cart (int id, int userID, String date, List<CartProduct> cartProducts) {}
