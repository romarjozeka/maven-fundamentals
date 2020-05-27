package com.example;

class Person {
    private final String firstName;
    private final String lastName;

    Person(String givenName, String surname) {
        this.firstName = givenName;
        this.lastName = surname;
    }

    String getFullName() {
        return lastName + ", " + firstName;
    }
}
