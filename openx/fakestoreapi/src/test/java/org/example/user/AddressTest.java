package org.example.user;

import org.example.model.Address;
import org.example.model.Geolocation;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest
{
    @Test
    public void getGeolocationTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address address = new Address(g, "San Francisco", "Warriors Way", 1, "94158");

        assertEquals(g, address.geolocation());
    }

    @Test
    public void getCityTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address address = new Address(g, "San Francisco", "Warriors Way", 1, "94158");

        assertEquals("San Francisco", address.getCity());
    }

    @Test
    public void getStreetTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address address = new Address(g, "San Francisco", "Warriors Way", 1, "94158");

        assertEquals("Warriors Way", address.getStreet());
    }

    @Test
    public void getNumberTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address address = new Address(g, "San Francisco", "Warriors Way", 1, "94158");

        assertEquals(1, address.getNumber());
    }

    @Test
    public void getZipcodeTest()
    {
        Geolocation g = new Geolocation(37.7749, -122.4194);
        Address address = new Address(g, "San Francisco", "Warriors Way", 1, "94158");

        assertEquals("94158", address.getZipcode());
    }

    @Test
    public void distanceFromTest()
    {
        Geolocation g = new Geolocation(3, 4);
        Geolocation g1 = new Geolocation(0, 0);

        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Address a1 = new Address(g1, "San Antonio", "AT&T Center Parkway", 1, "78219");

        assertEquals(5, a.distanceFrom(a1));
    }

    @Test
    public void distanceFromTestDifferentSigns()
    {
        Geolocation g = new Geolocation(-3, 4);
        Geolocation g1 = new Geolocation(3, -4);

        Address a = new Address(g, "San Francisco", "Warriors Way", 1, "94158");
        Address a1 = new Address(g1, "San Antonio", "AT&T Center Parkway", 1, "78219");

        assertEquals(10, a.distanceFrom(a1));
    }
}