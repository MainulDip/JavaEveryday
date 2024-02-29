package org.example.animal;


import org.jetbrains.annotations.NotNull;

public class Goat extends Animal implements Locomotion {

    public static String sth = "Sth";

    @Override
    protected String getSound() {
        // return null; // will mark by IDE if null is returned
        return sth;
    }

    @Override
    public String eats() {
        return "walks";
    }

    @Override
    public String getLocomotion() {
        return "grass";
    }

    public static void main(String[] args) {
        Goat goat = new Goat();
        System.out.println(goat.getSound().toLowerCase());
        System.out.println(goat.getLocomotion());
    }
}