package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    void testGetFullName() {
        Person p = new Person("Romarjo", "Zeka");
        String displayName = p.getFullName();
        assertEquals("Hayden, Josh", displayName);
    }
}
