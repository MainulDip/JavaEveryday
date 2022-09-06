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