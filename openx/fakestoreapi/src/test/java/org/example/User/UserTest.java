package org.example.User;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getAddressTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Name n = new Name("Stephen", "Curry");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");

        assertEquals(a, u.getAddress());
    }

    @Test
    void getIDTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Name n = new Name("Stephen", "Curry");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");

        assertEquals(1, u.getID());
    }

    @Test
    void getEmailTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Name n = new Name("Stephen", "Curry");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");

        assertEquals("email@gmail.com", u.getEmail());
    }

    @Test
    void getUsernameTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Name n = new Name("Stephen", "Curry");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");

        assertEquals("username", u.getUsername());
    }

    @Test
    void getPasswordTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Name n = new Name("Stephen", "Curry");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");

        assertEquals("password", u.getPassword());
    }

    @Test
    void getNameTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Name n = new Name("Stephen", "Curry");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");

        assertEquals(n, u.getName());
    }

    @Test
    void getPhoneTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Name n = new Name("Stephen", "Curry");

        User u = new User(a, 1, "email@gmail.com", "username", "password", n, "123456789");

        assertEquals("123456789", u.getPhone());
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

        assertEquals(0, User.findUserIndex(userList, 1));
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

        assertEquals(1, User.findUserIndex(userList, 2));
    }

    @Test
    void findUserIndexTestIndexNotPresent()
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

        assertEquals(-1, User.findUserIndex(userList, 7));
    }

    @Test
    void usersFurthestApart()
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

        assertEquals(expectedOutput, User.usersFurthestApart(userList));
    }
}