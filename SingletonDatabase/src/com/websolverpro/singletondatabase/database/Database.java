package com.websolverpro.singletondatabase.database;

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

public class Database {

    public String name;

    private static int state = 1;

    // volatile
    public static Database instance;

//    to force stop using multiple threads so there will be no multiple instance errors.
    public static synchronized Database getInstance(String name) {
        if( instance == null ) {
            instance = new Database(name);
        }
        System.out.println(instance.name);
        return instance;
    }

//    make constructor private to restrict access from outside to create instance.
    private Database(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        System.out.println("Counter is now: " + state);
        state++;
        return "Database{" +
                "name='" + name + '\'' +
                '}';
    }
}
