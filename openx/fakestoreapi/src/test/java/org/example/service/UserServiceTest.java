package org.example.service;

import org.example.model.Address;
import org.example.model.Geolocation;
import org.example.model.Name;
import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest
{
    @Test
    public void distanceFromTest()
    {
        // given
        Geolocation g = new Geolocation(3, 4);
        Geolocation g1 = new Geolocation(0, 0);

        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Address a1 = new Address(g1, "San Antonio", "AT&T Center Parkway", 1, "78219");

        // when
        double actualDistance = UserService.distanceFrom(a, a1);
        double expectedDistance = 5;

        // then
        assertEquals(expectedDistance, actualDistance);
    }

    @Test
    public void distanceFromTestDifferentSigns()
    {
        // given
        Geolocation g = new Geolocation(-3, 4);
        Geolocation g1 = new Geolocation(3, -4);

        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Address a1 = new Address(g1, "San Antonio", "AT&T Center Parkway", 1, "78219");

        // when
        double actualDistance = UserService.distanceFrom(a, a1);
        double expectedDistance = 10;

        // then
        assertEquals(expectedDistance, actualDistance);
    }

    @Test
    void usersFurthestApartTest()
    {
        Geolocation g = new Geolocation(3, -4);
        Geolocation g1 = new Geolocation(0, 0);
        Geolocation g2 = new Geolocation(6, -8);

        Address a = new Address(g, "San Francisco", "Warriors Way", 30, "94158");
        Address a1 = new Address(g1, "San Francisco", "Warriors Way", 11, "94158");
        Address a2 = new Address(g2, "San Francisco", "Warriors Way", 23, "94158");

        Name n = new Name("Stephen", "Curry");
        Name n1 = new Name("Klay", "Thompson");
        Name n2 = new Name("Draymond", "Green");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");
        User u1 = new User(a1, 2, "email@gmail.com", "username", "password", n1, "123456789");
        User u2 = new User(a2, 3, "email@gmail.com", "username", "password", n2, "123456789");

        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);

        String expectedOutput = "The biggest distance between users is between " + "Klay Thompson"
                + " and " + "Draymond Green" + " and is equal to " + (double)10;

        assertEquals(expectedOutput, UserService.usersFurthestApart(userList));
    }

    @Test
    void findUserIndexTestIndex0()
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

        // when
        int actualIndex = UserService.findUserIndex(userList, 1);
        int expectedIndex = 0;

        //then
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void findUserIndexTestIndex1()
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

        // when
        int actualIndex = UserService.findUserIndex(userList, 2);
        int expectedIndex = 1;

        // then
        assertEquals(expectedIndex, actualIndex);
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