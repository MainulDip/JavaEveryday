package JavaLanguageTour.asynchronousprogramming;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.*;

import static com.google.common.math.IntMath.factorial;

public class ThreadAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadAsync newThAs = new ThreadAsync();
//        newThAs.asyncByThread();
//        newThAs.asyncExecutor();
//        newThAs.asyncCompletableFuture();
        newThAs.asyncGuava();
    }


    public void asyncByThread() {
        int number = 20;
        Thread newThread = new Thread(() -> {
            System.out.println("Factorial of " + number + " is: " + factorial(number));
        });
        newThread.start();
    }

    void asyncExecutor() throws ExecutionException, InterruptedException {

        Integer number = 20;

        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Integer> futureTask = threadpool.submit(() -> factorial(number));

        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }
        long result = futureTask.get();
        System.out.println("asyncExecutor Result " + result);

        threadpool.shutdown();
    }

    void asyncCompletableFuture() throws ExecutionException, InterruptedException {
        Integer number = 20;
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> factorial(number));
        while (!completableFuture.isDone()) {
            System.out.println("CompletableFuture is not finished yet...");
        }
        long result = completableFuture.get();
        System.out.println("asyncCompletableFuture Result " + result);
    }

    void asyncGuava() throws ExecutionException, InterruptedException {
        Integer number = 20;
        ExecutorService threadpool = Executors.newCachedThreadPool();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(threadpool);
        ListenableFuture<Integer> guavaFuture = service.submit(()-> factorial(number));
        while (!guavaFuture.isDone()) {
            System.out.println("GuavaFuture is not finished yet...");
        }
        long result = guavaFuture.get();
        System.out.println("asyncGuava Result " + result);
    }


}
