package org.example.animal;


public class Goat extends Animal implements Locomotion {

    @Override
    protected String getSound() {
        return null;
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