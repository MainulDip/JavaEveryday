package org.example.animal;

import org.jetbrains.annotations.NotNull;

public abstract class Animal implements Eating {
    public static String CATEGORY = "domestic";
    private String name;
    protected abstract String getSound();

    public static String getCATEGORY() {
        return CATEGORY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

