package createThread;

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter1 {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}

public class Atomic2 {

    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 Started");
            for (int i = 0; i < 50000; i++) {
                sharedCounter.increment();
            }
            System.out.println("Thread 1 Completed");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 Started");
            for (int i = 0; i < 50000; i++) {
                sharedCounter.increment();
            }
            System.out.println("Thread 2 Completed");
        });

        t1.start();
        t2.start();

        // Wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + sharedCounter.getCount());
    }
}
