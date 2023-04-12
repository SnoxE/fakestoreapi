package org.example.service;


import org.example.model.Address;
import org.example.model.Geolocation;
import org.example.model.User;

import java.util.List;

public class UserService
{
    public static double distanceFrom(Address a1, Address a2)
    {
        Geolocation g1 = a1.geolocation();
        Geolocation g2 = a2.geolocation();

        double latitudinalDistance = g2.latitude() - g1.latitude();
        double longitudinalDistance = g2.longitude() - g1.longitude();

        return Math.sqrt(latitudinalDistance * latitudinalDistance + longitudinalDistance * longitudinalDistance);
    }

    public static int findUserIndex(List<User> userList, int id)
    {
        int index = -1; //starting from -1 in order to differentiate between index not found and index found at 0
        int iter = -1;
        for(User u : userList)
        {
            if(u.id() == id)
            {
                index = ++iter;
                break;
            }

            iter++;
        }

        return index;
    }


    // utilities
    public static String usersFurthestApart(List<User> userList)
    {
        double maxDistance = 0;
        int outerMaxIndex = 0;
        int innerMaxIndex = 0;

        for(int i = 0; i < userList.size(); i++)
        {
            for(int j = i + 1; j < userList.size(); j++)
            {
                User outerLoopUser = userList.get(i);
                User innerLoopUser = userList.get(j);

                if(UserService.distanceFrom(outerLoopUser.address(), innerLoopUser.address()) > maxDistance)
                {
                    maxDistance = UserService.distanceFrom(outerLoopUser.address(), innerLoopUser.address());
                    outerMaxIndex = i;
                    innerMaxIndex = j;
                }
            }
        }

        User u1 = userList.get(outerMaxIndex);
        User u2 = userList.get(innerMaxIndex);

        return "The biggest distance between users is between " + u1.name()
                + " and " + u2.name() + " and is equal to " + maxDistance;
    }
}
