package org.example.animal;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Goat extends Animal implements Locomotion {

    String name;

//    List<? super > numList = Arrays.asList(4, 5, 6, 7);

    @Override
    protected String getSound() {
        return "bleat";
    }

    @Override
    public String eats() {
        return "walks";
    }

    @Override
    public String getLocomotion() {
        return "grass";
    }

    public Goat(String name) {
        super(name);
        this.name = name;
    }

    //    public static void main(String[] args) {
//        Goat goat = new Goat();
//        System.out.println(goat.getSound().toLowerCase());
//        System.out.println(goat.getLocomotion());
//    }
}