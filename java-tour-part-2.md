### Overview:
Continued From java-language-tour.md (follow the overview)

### Interfaces:

- supports multiple inheritance of interfaces "public class Car implements Fly, Transform {}"

- use constants variables, abstract methods, static methods, default methods in interface

- can't instantiate interfaces directly

- interface can be empty, with no methods or variables in it

- we can't use the final word in the interface definition, as it will result in a compiler error

- all interface declarations should have the public or default access modifier; the abstract modifier will be added automatically by the compiler

- an interface method can't be protected or final

- up until Java 9, interface methods could not be private; however, Java 9 introduced the possibility to define private methods in interfaces

- interface variables are public, static, and final by definition; we're not allowed to change their visibility

- When an interface extends another interface, it inherits all of that interface's abstract methods

- When an abstract class implements an interface, it inherits all of its abstract and default methods.

```java
public interface Electronic {

    // Constant variable
    String LED = "LED";

    // Abstract method, must be overried
    int getElectricityUse();

    // Static method
    static boolean isEnergyEfficient(String electtronicType) {
        if (electtronicType.equals(LED)) {
            return true;
        }
        return false;
    }

    //Default method, it is optional and can be implemented at the interface level.
    default void printDescription() {
        System.out.println("Electronic Description");
    }
}

public class Computer implements Electronic {

    @Override
    public int getElectricityUse() {
        return 1000;
    }
}
```

### Abstract classes: