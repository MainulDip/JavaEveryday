package com.MainulDip;

public class Person2 {
    public String firstName;
    public String lastName;
    public String middleName;
    private int userId;

//  use shift+alt+enter to generate constructor function
    public Person2(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFullName() {
        return firstName + middleName + lastName;
    }

    public static String sayWelcome () {
        return "Welcome To Java";
    }

    @Override
    public String toString() {
        return "Person2{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
