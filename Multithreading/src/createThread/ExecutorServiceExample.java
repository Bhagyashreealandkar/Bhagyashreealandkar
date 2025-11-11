package createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
	
//	newSingleThreadExecutor()	Executes tasks sequentially using one thread.
//	newFixedThreadPool(n)	Uses a fixed number of threads, reuses them for tasks.
//	newCachedThreadPool()	Creates new threads as needed but reuses idle threads.
//	newScheduledThreadPool(n)	Supports delayed and repeating tasks.

	public static void main(String[] args) {
		 // 1. Single Thread Executor
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("Single Thread Executor:");
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            singleThreadExecutor.execute(() -> {
                System.out.println("Single Thread Task " + taskId + 
                    " executed by Thread: " + Thread.currentThread().getName());
            });
        }
        singleThreadExecutor.shutdown();


        // 2. Fixed Thread Pool (e.g., 3 threads)
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        System.out.println("\nFixed Thread Pool:");
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            fixedThreadPool.execute(() -> {
                System.out.println("Fixed Thread Task " + taskId +
                    " executed by Thread: " + Thread.currentThread().getName());
            });
        }
        fixedThreadPool.shutdown();


        // 3. Cached Thread Pool (creates new threads as needed, reuses idle ones)
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("\nCached Thread Pool:");
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            cachedThreadPool.execute(() -> {
                System.out.println("Cached Thread Task " + taskId +
                    " executed by Thread: " + Thread.currentThread().getName());
            });
        }
        cachedThreadPool.shutdown();


        // 4. Scheduled Thread Pool (not shown in the video, but useful)
        // Used for delayed or periodic task execution
        // Example:
        // ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        // scheduledPool.schedule(() -> System.out.println("Delayed Task"), 3, TimeUnit.SECONDS);
        // scheduledPool.shutdown();
        
        
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            scheduledThreadPool.schedule(() -> {
                System.out.println("Scheduled Thread Task " + taskId +
                    " executed by Thread: " + Thread.currentThread().getName());
            }, 3, TimeUnit.SECONDS); // 👈 Delays execution by 3 seconds
        }

        scheduledThreadPool.shutdown();


	}

}
