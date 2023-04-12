package org.example.service;

import org.example.model.Address;
import org.example.model.Geolocation;
import org.example.model.Name;
import org.example.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void distanceFromTest()
    {
    }

    @Test
    void findUserIndex() {
    }

    @Test
    void usersFurthestApart() {
    }

    @Test
    void findUserIndexTestIndex0()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Name n = new Name("Stephen", "Curry");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");
        User u1 = new User(a, 2, "email@gmail.com", "username", "password", n, "123456789");
        User u2 = new User(a, 3, "email@gmail.com", "username", "password", n, "123456789");

        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);

        assertEquals(0, UserService.findUserIndex(userList, 1));
    }

    @Test
    void findUserIndexTestIndex1()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Name n = new Name("Stephen", "Curry");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");
        User u1 = new User(a, 2, "email@gmail.com", "username", "password", n, "123456789");
        User u2 = new User(a, 3, "email@gmail.com", "username", "password", n, "123456789");

        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);

        assertEquals(1, UserService.findUserIndex(userList, 2));
    }

    @Test
    void findUserIndexTestIndexNotPresent()
    {
        // given
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Name n = new Name("Stephen", "Curry");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");
        User u1 = new User(a, 2, "email@gmail.com", "username", "password", n, "123456789");
        User u2 = new User(a, 3, "email@gmail.com", "username", "password", n, "123456789");

        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);

        // then
        int actualIndex = UserService.findUserIndex(userList, 7);
        int expectedIndex = -1;

        assertEquals(expectedIndex, actualIndex);
    }
}