package org.example.animal;

import org.jetbrains.annotations.NotNull;

public abstract class Animal implements Eating {
    public static String CATEGORY = "domestic";
    private String name;
    protected abstract String getSound();
}

