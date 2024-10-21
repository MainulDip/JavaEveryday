### Async Programmming
- thread
- runnable
- callback : https://www.geeksforgeeks.org/asynchronous-synchronous-callbacks-java/
- future
- callable
- completableFuture

### AtomicInteger:
It's a java.util.concurrent.atomic.AtomicInteger class provides operations on underlying int value that can be read and written atomically, and also contains advanced atomic operations.

- without AtomicInteger
```java
public class TestThread {

   static class Counter {
      private int c = 0;

      public void increment() {
         c++;
      }

      public int value() {
         return c;
      }
   }
   
   public static void main(final String[] arguments) throws InterruptedException {
      final Counter counter = new Counter();
      
      //1000 threads
      for(int i = 0; i < 1000 ; i++) {
         
         new Thread(new Runnable() {
            
            public void run() {
               counter.increment();
            }
         }).start(); 
      }  
      Thread.sleep(6000);
      System.out.println("Final number (should be 1000): " + counter.value());
   }  
}
```

- Using AtomicInteger:
```java
public class TestThread {

   static class Counter {
      private AtomicInteger c = new AtomicInteger(0);

      public void increment() {
         c.getAndIncrement();
      }

      public int value() {
         return c.get();
      }
   }
   
   public static void main(final String[] arguments) throws InterruptedException {
      final Counter counter = new Counter();
      
      //1000 threads
      for(int i = 0; i < 1000 ; i++) {

         new Thread(new Runnable() {
            public void run() {
               counter.increment();
            }
         }).start(); 
      }  
      Thread.sleep(6000);
      System.out.println("Final number (should be 1000): " + counter.value());
   }
}
```

### CountDownLatch:
CountDownLatch has a counter field, which can be decremented as required. We can then use it to block a calling thread until it's been counted down to zero.
```kotlin
// done in kotlin, works same in Java
val countDownLatch = CountDownLatch(repos.size)
for (repo in repos) {
    service.getRepoContributorsCall(req.org, repo.name)
        .onResponse { responseUsers ->
            // processing repository
            countDownLatch.countDown()
        }
}
countDownLatch.await() // blocks code execution until finished to zero
updateResults(allUsers.aggregate())
```

### Callback & Closure
A CallBack Function is a function that is passed into another function as an argument and is expected to execute after some kind of event. The purpose of the callback function is to inform a class Sync/Async if some work in another class is done. This is also used in event handling, as we get notified when a button is clicked via callback function.

This type of design pattern is used in Observer Design Pattern.The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its dependent, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.

In Java, Callbacks can be implemented using an interface. The general procedure are:
  1. Define the methods in an interface that we want to invoke after callback.
  2. Define a class that will implement the callback methods of the interface.
  3. Define a reference in other class to register the callback interface.
  4. Use that reference to invoke the callback method.

https://www.geeksforgeeks.org/asynchronous-synchronous-callbacks-java/
### Lambda:
In Java Lambda is used to implement `SAM` interface, its implementation signature is `(props:T) -> {}`. Note, there is no return type like kotlin, as the return type is declared in the `SAM` interface class.


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

https://rjlfinn.medium.com/asynchronous-programming-in-java-d6410d53df4d.


### Thread Pool
Thread pool is a pattern. Other than  creating a new thread each time a request arrives and service this new request in the newly created thread, it reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing. Since the thread is already existing when the request arrives, the delay introduced by thread creation is eliminated, making the application more responsive.


Based on Thread Pool Java provides the Executor framework which is centered around the Executor interface, its sub-interface –ExecutorService and the class-ThreadPoolExecutor, which implements both of these interfaces. By using the executor, one only has to implement the Runnable objects and send them to the executor to execute.
- this Executor Framework (Thread Pool) provides advantage of threading, but focus on the tasks that you want the thread to perform, instead of thread mechanics.

- To use thread pools, we first create a object of ExecutorService and pass a set of tasks to it. ThreadPoolExecutor class allows to set the core and maximum pool size.The runnables that are run by a particular thread are executed sequentially.

### Executor Thread Pool Methods:
 - newFixedThreadPool(int) : Creates a fixed size thread pool. if all threads are being currently run by the executor then the pending tasks are placed in a queue and are executed when a thread becomes idle.
 - newCachedThreadPool() : Creates a thread pool that creates new threads as needed, reuse previously constructed threads are available
 - newSingleThreadExecutor() : Creates a single thread.

 Example:
 Here we are controlling Task (Runnable interface) using Executors.newFixedThreadPool(int) which returns ExecutorService (java.util.concurrent.ExecutorService) or ThreadPoolExecutor which implements ExecutorService. Then we call the (ThreadPoolExecutor) "pool"'s "execute" method to run the tasks (Runnable) sequentially. The Task (Runnable) is setup to pause/hold the thread using "Thread.sleep(1000) to check the behaver of "Thread Poos" implementation and how "java.util.concurrent.ExecutorService" reuse the paused thread, queue and complete tasks.

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

### Java 21 Virtual Threads