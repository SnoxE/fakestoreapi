package org.example.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeolocationTest {

    @Test
    void getLatitudeTest()
    {
        Geolocation g = new Geolocation(3, 4);
        assertEquals(3, g.getLatitude());
    }

    @Test
    void getLongitudeTest()
    {
        Geolocation g = new Geolocation(3, 4);
        assertEquals(4, g.getLongitude());
    }

    @Test
    void constructorTest()
    {
        Geolocation g = new Geolocation(4, 55);
        assertEquals(4, g.getLatitude());
        assertEquals(55, g.getLongitude());
    }
}