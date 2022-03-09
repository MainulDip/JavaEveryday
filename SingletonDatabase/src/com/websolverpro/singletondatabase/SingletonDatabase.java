package com.websolverpro.singletondatabase;

import com.websolverpro.singletondatabase.database.Database;

/**
 * Singleton Pattern
 * Force using only one instance and stop creating multiple instance
 * Force thread safe.
 * Tracks single instance through static prop and method, as static props and methods belongs to that class inseft, not to the instances
 * As static props and methods belongs to that object/class itself, it can be used as a counter.
 * we instantiate the object by calling the static method and keep tracks of the instance number through static property by checking instance == null
 * Also restrict calling of the constructor from outside the class using encapsulation (private)
 * Also make getInstance method thread safe using 'synchronized' keyword, it restricts multiple thread to call this method.
 * If multiple thread call this method at the same time, there might be some chance of getting multiple instance created.
 */

public class SingletonDatabase {
    public static void main(String[] args) {
        System.out.println("Starting Singleton Pattern Database");
        Database database = Database.getInstance("singleton-database");
        Database anotherDatabase = Database.getInstance("Second Database");

        System.out.println("First Database Name: " + database.getName()); // First Database Name: singleton-database
        System.out.println("Second Database Name: " + anotherDatabase.getName()); // First Database Name: singleton-database

        database.toString(); // Counter is now: 1
        anotherDatabase.toString(); // Counter is now: 2
        database.toString(); // Counter is now: 3
        anotherDatabase.toString(); // Counter is now: 4
    }
}
