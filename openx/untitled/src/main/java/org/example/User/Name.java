package org.example.User;

public class Name
{
    String firstname;
    String lastname;

    public Name(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
}
