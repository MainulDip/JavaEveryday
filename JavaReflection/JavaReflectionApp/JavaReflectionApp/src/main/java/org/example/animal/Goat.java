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
        this.name = name;
    }

    //    public static void main(String[] args) {
//        Goat goat = new Goat();
//        System.out.println(goat.getSound().toLowerCase());
//        System.out.println(goat.getLocomotion());
//    }

    public static void main(String[] args) {
        // Lower Bounded Integer List
        List<Integer> list1 = Arrays.asList(4, 5, 6, 7);

        // Integer list object is being passed
        printOnlyIntegerClassorSuperClass(list1);

        // Number list
        List<Number> list2 = Arrays.asList(4, 5, 6, 7);

        // Integer list object is being passed
        printOnlyIntegerClassorSuperClass(list2);

        List<Double> list3 = Arrays.asList(4.0, 5.0, 6.0, 7.0);

        // Integer list object is being passed
//        printOnlyIntegerClassorSuperClass(list3);
    }

    public static void printOnlyIntegerClassorSuperClass(
            List<? super Integer> list) {
        System.out.println(list);
    }
}