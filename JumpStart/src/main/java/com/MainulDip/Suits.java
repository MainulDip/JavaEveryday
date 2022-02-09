package com.MainulDip;

public enum Suits {
//  instantiate multiple objects from this class within this class
    HEARTS("Hearts", "red"), DIAMONDS("Diamonds", "White"),
    SPADES("Spades", "Blue"), CLUBS("Clubs", "Green");

    public final String displayName;
    public final String color;

//  Construction
    Suits(String displayName, String color) {
        this.displayName = displayName;
        this.color = color;
    }
//  Works like source of truth along the application
}
