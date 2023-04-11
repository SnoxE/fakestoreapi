package org.example.User;

public class Geolocation
{
    double latitude;
    double longitude;

    public Geolocation(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}
