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
```java
abstract class Shape 
{
    int color;
    // An abstract function
    abstract void draw();
}
```
> abstract class observations

- An instance of an abstract class can not be created.

- Constructors are allowed.

- We can have an abstract class without any abstract method.

- There can be a final method in abstract class but any abstract method in class(abstract class) can not be declared as final  or in simper terms final method can not be abstract itself as it will yield an error: “Illegal combination of modifiers: abstract and final”

- We are not allowed to create objects for an abstract class.

- We can define static methods in an abstract class

- We can use the abstract keyword for declaring top-level classes (Outer class) as well as inner classes as abstract

- If a class contains at least one abstract method then compulsory should declare a class as abstract 

- If the Child class is unable to provide implementation to all abstract methods of the Parent class then we should declare that Child class as abstract so that the next level Child class should provide implementation to the remaining abstract method

```java
abstract class B {
  //declaring inner class as abstract with abstract method
    abstract class C {
        abstract void myAbstractMethod();
    }
}
class D extends B {
    class E extends C {
      // implementing the abstract method
        void myAbstractMethod() { System.out.println("Inside abstract method implementation"); }
    }
}
 
public class Main {
 
    public static void main(String args[])
    {
        // Instantiating the outer class
        D outer = new D();
 
        // Instantiating the inner class
        D.E inner = outer.new E();
        inner.myAbstractMethod(); // Inside abstract method implementation
    }
}
```

### More on Generics:
Generics was added in Java 5 to provide compile-time type checking and removing risk of ClassCastException that was common while working with collection classes.

- List Generics
```java
List<String> list1 = new ArrayList<String>(); // java 7 ? List<String> list1 = new ArrayList<>(); 
list1.add("abc");
//list1.add(new Integer(5)); //compiler error

// parameterized value to a parameterized type like => new HashMap<String, List<String>>()

for(String str : list1){
     //no type casting needed, avoids ClassCastException
}
```
- Generic Class and interface:

```java

public class GenericsType<T> {

	private T t;
	
	public T get(){
		return this.t;
	}
	
	public void set(T t1){
		this.t=t1;
	}
	
	public static void main(String args[]){
		GenericsType<String> type = new GenericsType<>();
		type.set("Pankaj"); //valid
		
		GenericsType type1 = new GenericsType(); //raw type
		type1.set("Pankaj"); //valid
		type1.set(10); //valid and autoboxing support
	}
}

// interface
public interface Comparable<T> {
    public int compareTo(T o);
}
```

- Generic Naming Convention:
 - E - Element (used extensively by the Java Collections Framework,  f or example ArrayList, Set etc.)
 - K - Key (Used in Map)
 - N - Number
 - T - Type
 - V - Value (Used in Map)
 - S,U,V etc. - 2nd, 3rd, 4th types


- Bounded Type:
This is used to restrict the type of objects (upper bound limit) that can be used in the parameterized type. To declare a bounded type parameter, list the type parameter’s name, followed by the extends keyword, followed by its upper bound. Java Generics supports multiple bounds also, i.e <T extends A & B & C>
```java
public static <T extends Comparable<T>> int compare(T t1, T t2){
		return t1.compareTo(t2);
	}
```

### Generics Wildcard Bounded(<? extends Object>) / Unbounded(List<?>, etc) / Lower-Bounded (List<? super Integer>):
The question mark (?), represents the wildcard, stands for unknown type in generics. There are 3 types of Generics Wildcards.

 1. Upper-Bound / Subtyping Wildcard:
 Upper bounded wildcards are used to relax the restriction on the type of variable in a method.
```java
public static void main(String[] args) {
    List<Integer> ints = new ArrayList<>();
    ints.add(3); ints.add(5); ints.add(10);
    double sum = sum(ints);
    System.out.println("Sum of ints="+sum);
}

public static double sum(List<? extends Number> list){
    double sum = 0;
    for(Number n : list){
        sum += n.doubleValue();
    }
    return sum;
}
```
```java
List<? extends Integer> intList = new ArrayList<>();
List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
```
2. Unbounded Wildcard:
Allow generic method to work with all types. Its same as using <? extends Object>.
```java
public static void printData(List<?> list){
    for(Object obj : list){
        System.out.print(obj + "::");
    }
}
```

3. Lower-Bounded Wildcard / contravariance:
When Generic methods argument can be that Type <T> or superclass of the Type <T>

```java

public class GenericsTester {

   public static void addCat(List<? super Cat> catList) {
      catList.add(new RedCat());
      System.out.println("Cat Added");
   }

   public static void main(String[] args) {
      List<Animal> animalList= new ArrayList<Animal>();
      List<Cat> catList= new ArrayList<Cat>();
      List<RedCat> redCatList= new ArrayList<RedCat>();
      List<Dog> dogList= new ArrayList<Dog>();

      //add list of super class Animal of Cat class
      addCat(animalList);

      //add list of Cat class
      addCat(catList);

      //compile time error
      //can not add list of subclass RedCat of Cat class
      //addCat(redCatList);

      //compile time error
      //can not add list of subclass Dog of Superclass Animal of Cat class
      //addCat.addMethod(dogList); 
   }
}
class Animal {}

class Cat extends Animal {}

class RedCat extends Cat {}

class Dog extends Animal {}
```

### Generics Type Erasure:
Java Generics provide type-checking at compile time and it has no use at run time, so java compiler uses type erasure feature to remove all the generics type checking code in byte code and insert type-casting if necessary. Type erasure ensures that no new classes are created for parameterized types; consequently, generics incur no runtime overhead.

### Callback & Closure
A CallBack Function is a function that is passed into another function as an argument and is expected to execute after some kind of event. The purpose of the callback function is to inform a class Sync/Async if some work in another class is done. This is also used in event handling, as we get notified when a button is clicked via callback function.

This type of design pattern is used in Observer Design Pattern.The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its dependent, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.

In Java, Callbacks can be implemented using an interface. The general procedure are:
  1. Define the methods in an interface that we want to invoke after callback.
  2. Define a class that will implement the callback methods of the interface.
  3. Define a reference in other class to register the callback interface.
  4. Use that reference to invoke the callback method.

https://www.geeksforgeeks.org/asynchronous-synchronous-callbacks-java/
### Lambda


### Runnable vs Callable:
Both interfaces are designed to represent a task that can be run by multiple threads. We can run Runnable tasks using the Thread class or ExecutorService, whereas we can only run Callables using the latter/ExecutorService.

```java
// Runnable
class RunnableImpl implements Runnable {
 
  public void run()
  {
    System.out.println("Hello World from a different thread than Main");
  }
}
public class RunnableExample{
    static ExecutorService executor = Executors.newFixedThreadPool(2);
  public static void main(String[] args){
          // Creating and running runnable task using Thread class
          RunnableImpl task = new RunnableImpl();
        Thread thread = new Thread(task);
          thread.start();
          // Creating and running runnable task using Executor Service.
          executor.submit(task);
    }
}

// Callable
class CallableMessage implements Callable<String>{
  public String call() throws Exception{
      return "Hello World!";
  } 
}
 
public class CallableExample{
  static ExecutorService executor = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws Exception{
        CallableMessage task = new CallableMessage();
         Future<String> message = executor.submit(task);
         System.out.println(message.get().toString());
    }
}
```

### Future Interface:
 A Java Future, java.util.concurrent.Future, represents the result of an asynchronous computation. When the asynchronous task is created, a Java Future object is returned. This Future object functions as a handle to the result of the asynchronous task. Once the asynchronous task completes, the result can be accessed via the Future object returned when the task was started.

Some of Java's built-in concurrency utilities, like e.g. the Java ExecutorService, return a Java Future object from some of their methods. In the case of the ExecutorService, it returns a Future when you submit a Callable for it to execute concurrently (asynchronously).

```java
// Future Interface Signature
public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning)
    V       get();
    V       get(long timeout, TimeUnit unit);
    boolean isCancelled();
    boolean isDone();
}
```

### Completable Future:
https://blog.devgenius.io/details-implementation-of-java-asynchronous-programming-using-completable-future-949826bac6f3

https://rjlfinn.medium.com/asynchronous-programming-in-java-d6410d53df4d

### Java Light-Weight-Thread (Kotlin Coroutine) Implementation:
https://medium.com/@esocogmbh/coroutines-in-pure-java-65661a379c85