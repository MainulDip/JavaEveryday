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
 A Java Future, java.util.concurrent.Future, represents the result of an asynchronous computation, added in Java 5. When the asynchronous task is created, a Java Future object is returned. This Future object functions as a handle to the result of the asynchronous task. Once the asynchronous task completes, the result can be accessed via the Future object returned when the task was started. But alone, it doesn't provide error handling.

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
Java 8 introduced the CompletableFuture class. Along with the Future interface as Concurrency API improvement. it also implemented the CompletionStage interface. This interface defines the contract for an asynchronous computation step that we can combine with other steps with error handling. It is about 50 different methods for composing, combining, and executing asynchronous computation steps and handling errors.

 - ### Using CompletableFuture as a Simple Future:
 CompletableFuture class implements the Future interface, so we can use it as a Future implementation, but with additional completion logic.
```java
public Future<String> calculateAsync() throws InterruptedException{
    CompletableFuture<String> completableFuture = new CompletableFuture<>();

    Executors.newCachedThreadPool().submit(() -> {
        Thread.sleep(500);
        completableFuture.complete("Hello");
        return null;
    });

    return completableFuture;
}

public static void main(){
    Future<String> completableFuture = calculateAsync();
    String result = completableFuture.get();
    assertEquals("Hello", result);

    // standalone test
    testComputableStandalone()
}

public boolean testComputableStandalone(){
    Future<String> completableFuture = 
    CompletableFuture.completedFuture("Hello");
    String result = completableFuture.get();
    assertEquals("Hello", result);
}
```
- ### CompletableFuture's runAsync and supplyAsync:
Static methods runAsync and supplyAsync allow us to create a CompletableFuture instance out of Runnable and Supplier functional types correspondingly. Both are functional interfaces that allow passing their instances as lambda expressions.

The Runnable interface is the same old interface that is used in threads and it does not allow to return a value.

The Supplier interface is a generic functional interface with a single method that has no arguments and returns a value of a parameterized type.
```java
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
assertEquals("Hello", future.get());
```
- ### thenApply() : Processing Results of Asynchronous Computations
thenApply() accepts a Function instance, uses it to process the result, and returns a Future that holds a value returned by a function. We can also use thenAccept() and thenRun() methods.
```java
CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

CompletableFuture<String> future = completableFuture.thenApply(s -> s + " World");

// CompletableFuture<Void> future = completableFuture.thenAccept(s -> System.out.println("Computation returned: " + s));

// CompletableFuture<Void> future = completableFuture.thenRun(() -> System.out.println("Computation finished."));

assertEquals("Hello World", future.get());
```
- ### Combining/Chaining Futures:
```java
CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello").thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
assertEquals("Hello World", completableFuture.get());
```
- ### Running Multiple Futures in Parallel:
```java
CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

CompletableFuture<Void> combinedFuture= CompletableFuture.allOf(future1, future2, future3);

combinedFuture.get();

assertTrue(future1.isDone());
assertTrue(future2.isDone());
assertTrue(future3.isDone());
```
- CompletableFuture Error Handling:
```java
String name = null;

CompletableFuture<String> completableFuture =  CompletableFuture.supplyAsync(() -> {
      if (name == null) {
          throw new RuntimeException("Computation error!");
      }
      return "Hello, " + name;
  }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

assertEquals("Hello, Stranger!", completableFuture.get());

// using completeExceptionally
CompletableFuture<String> completableFuture = new CompletableFuture<>();

completableFuture.completeExceptionally(
  new RuntimeException("Calculation failed!"));
```

https://www.baeldung.com/java-completablefuture
https://blog.devgenius.io/details-implementation-of-java-asynchronous-programming-using-completable-future-949826bac6f3

https://rjlfinn.medium.com/asynchronous-programming-in-java-d6410d53df4d


### Thread Pool:
Thread pool is a pattern. Other than  creating a new thread each time a request arrives and service this new request in the newly created thread, it reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing. Since the thread is already existing when the request arrives, the delay introduced by thread creation is eliminated, making the application more responsive.


Based on Thread Pool Java provides the Executor framework which is centered around the Executor interface, its sub-interface –ExecutorService and the class-ThreadPoolExecutor, which implements both of these interfaces. By using the executor, one only has to implement the Runnable objects and send them to the executor to execute.
- this Executor Framework (Thread Pool) provides advantage of threading, but focus on the tasks that you want the thread to perform, instead of thread mechanics.

- To use thread pools, we first create a object of ExecutorService and pass a set of tasks to it. ThreadPoolExecutor class allows to set the core and maximum pool size.The runnables that are run by a particular thread are executed sequentially.

### Executor Thread Pool Methods:
 - newFixedThreadPool(int) : Creates a fixed size thread pool. if all threads are being currently run by the executor then the pending tasks are placed in a queue and are executed when a thread becomes idle.
 - newCachedThreadPool() : Creates a thread pool that creates new threads as needed, reuse previously constructed threads are available
 - newSingleThreadExecutor() : Creates a single thread.

 Example:
 Here we are controling Task (Runnable interface) using Executors.newFixedThreadPool(int) which returns ExecutorService (java.util.concurrent.ExecutorService) or ThreadPoolExecutor which implements ExecutorService. Then we call the (ThreadPoolExecutor) "pool"'s "execute" method to run the tasks (Runnable) sequentially. The Task (Runnable) is setup to pause/hold the thread using "Thread.sleep(1000) to check the behavour of "Thread Poos" implementation and how "java.util.concurrent.ExecutorService" resue the paused thread, queque and complete tasks.

```java
// Java Thread Pool Implementation using Executor's Fixed Thread Pool
  
// Task class to be executed (Step 1)
class Task implements Runnable   
{
    private String name;
      
    public Task(String s)
    {
        name = s;
    }
      
    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
    public void run()
    {
        try
        {
            for (int i = 0; i<=5; i++)
            {
                if (i==0)
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization Time for"
                            + " task name - "+ name +" = " +ft.format(d));   
                    //prints the initialization time for every task 
                }
                else
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Executing Time for task name - "+
                            name +" = " +ft.format(d));   
                    // prints the execution time for every task 
                }
                Thread.sleep(1000);
            }
            System.out.println(name+" complete");
        }
          
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
public class Test
{
     // Maximum number of threads in thread pool
    static final int MAX_T = 3;             
  
    public static void main(String[] args)
    {
        // creates five tasks
        Runnable r1 = new Task("task 1");
        Runnable r2 = new Task("task 2");
        Runnable r3 = new Task("task 3");
        Runnable r4 = new Task("task 4");
        Runnable r5 = new Task("task 5");      
          
        // creates a thread pool with MAX_T no. of 
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
         
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5); 
          
        // pool shutdown ( Step 4)
        pool.shutdown();    
    }
}
```
Output:
```txt
Initialization Time for task name - task 3 = 07:36:37
Initialization Time for task name - task 1 = 07:36:37
Initialization Time for task name - task 2 = 07:36:37
Executing Time for task name - task 1 = 07:36:38
Executing Time for task name - task 2 = 07:36:38
Executing Time for task name - task 3 = 07:36:38
Executing Time for task name - task 2 = 07:36:39
Executing Time for task name - task 3 = 07:36:39
Executing Time for task name - task 1 = 07:36:39
Executing Time for task name - task 2 = 07:36:40
Executing Time for task name - task 3 = 07:36:40
Executing Time for task name - task 1 = 07:36:40
Executing Time for task name - task 2 = 07:36:41
Executing Time for task name - task 1 = 07:36:41
Executing Time for task name - task 3 = 07:36:41
Executing Time for task name - task 2 = 07:36:42
Executing Time for task name - task 3 = 07:36:42
Executing Time for task name - task 1 = 07:36:42
task 2 complete
Initialization Time for task name - task 4 = 07:36:43
task 3 complete
task 1 complete
Initialization Time for task name - task 5 = 07:36:43
Executing Time for task name - task 5 = 07:36:44
Executing Time for task name - task 4 = 07:36:44
Executing Time for task name - task 4 = 07:36:45
Executing Time for task name - task 5 = 07:36:45
Executing Time for task name - task 4 = 07:36:46
Executing Time for task name - task 5 = 07:36:46
Executing Time for task name - task 5 = 07:36:47
Executing Time for task name - task 4 = 07:36:47
Executing Time for task name - task 5 = 07:36:48
Executing Time for task name - task 4 = 07:36:48
task 4 complete
task 5 complete
```



https://www.geeksforgeeks.org/thread-pools-java/
https://www.baeldung.com/thread-pool-java-and-guava
### Java Light-Weight-Thread (Kotlin Coroutine) Implementation:
https://medium.com/@esocogmbh/coroutines-in-pure-java-65661a379c85