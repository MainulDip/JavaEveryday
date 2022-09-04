package JavaLanguageTour.asynchronousprogramming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;

public class LambdaCallableTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable c = () -> {   // Lambda Expression
            int n = 0;
            for(int i = 0; i < 100; i++) {
                n += i;
            }
            return n;
        };
        Future future = executor.submit(c);
        try {
            Integer result = (Integer) future.get(); //wait for a thread to complete
            System.out.println(result);
        } catch(ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
