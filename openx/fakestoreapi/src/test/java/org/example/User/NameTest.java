package org.example.User;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void getFirstnameTest()
    {
        Name name = new Name("Stephen", "Curry");
        assertEquals("Stephen", name.getFirstname());
    }

    @Test
    void getLastnameTest()
    {
        Name name = new Name("Stephen", "Curry");
        assertEquals("Curry", name.getLastname());
    }

    @Test
    void toStringTest()
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Name name = new Name("Stephen", "Curry");
        System.out.println(name);

        assertEquals("Stephen Curry\r\n", outContent.toString());
    }
}