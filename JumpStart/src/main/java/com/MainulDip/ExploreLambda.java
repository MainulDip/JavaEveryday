package com.MainulDip;

@FunctionalInterface // optional annotation, but increase readability
interface StringFunction {
//  this is a functional interface or "Single Abstract Method Interface"
//  lambda function can only provide the implementation for 1 method
    String run(String str, String anotherStr);
//    String again(String str, String anotherStr); // if used, lambda cannot handle more than one abstract method

    default void defaultMethod(){
        System.out.println("You can access this class with extended class without overriding");
    }
}

public class ExploreLambda {
    public static void main(String[] args) {
        StringFunction exclaim = (s, t) -> {
            return s + "!" + t + " 77";
        };
        StringFunction ask = (s, t) -> s + t + " ?";
//        System.out.println(exclaim("good", "boy"));
        printFormatted("Hello", "World", exclaim);
        exclaim.defaultMethod();
        printFormatted("Hello", "Dolly", ask);
    }
    public static void printFormatted(String str, String str2, StringFunction format) {
        String result = format.run(str, str2);
        format.defaultMethod();
        System.out.println(result);
    }
}
