package org.example.User;

import org.example.Product.Product;

import java.util.List;

public class User
{
    Address address;
    int id;
    String email;
    String username;
    String password;
    Name name;
    String phone;

    public User(Address address, int id, String email, String username,
                String password, Name name, String phone)
    {
        this.address = address;
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    // getters
    public Address getAddress() { return address; }
    public int getID() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Name getName() { return name; }
    public String getPhone() { return phone; }

//    @Override
//    public String toString()
//    {
//        return "id: " + id + "\nemail: " + email + "\n";
//    }

    public static int findUserIndex(List<User> userList, int id)
    {
        int index = -1; //starting from -1 in order to differentiate between index not found and index found at 0
        int iter = -1;
        for(User u : userList)
        {
            if(u.getID() == id)
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

                if(outerLoopUser.getAddress().distanceFrom(innerLoopUser.getAddress()) > maxDistance)
                {
                    maxDistance = outerLoopUser.getAddress().distanceFrom(innerLoopUser.getAddress());
                    outerMaxIndex = i;
                    innerMaxIndex = j;
                }
            }
        }

        User u1 = userList.get(outerMaxIndex);
        User u2 = userList.get(innerMaxIndex);

        return "The biggest distance between users is between " + u1.getName()
                + " and " + u2.getName() + " and is equal to " + maxDistance;
    }
}
