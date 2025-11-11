package createThread;

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter {

    private int count;

    public void increment() {
        count++; 
    }

    public int getCount() {
        return count;
    }

//	private AtomicInteger count = new AtomicInteger(0);
//
//	public void increment() {
//		count.incrementAndGet();
//	}
//
//	public int getCount() {
//		return count.get();
//	}
}

public class Atomic {

	public static void main(String[] args) {
		SharedCounter1 sharedCounter = new SharedCounter1();

		// Thread 1
		new Thread(() -> {
			System.out.println("Thread 1 Started");
			for (int i = 0; i < 50000; i++) {
				sharedCounter.increment();
			}
			System.out.println("Thread 1 Completed");
		}).start();

		// Thread 2
		new Thread(() -> {
			System.out.println("Thread 2 Started");
			for (int i = 0; i < 50000; i++) {
				sharedCounter.increment();
			}
			System.out.println("Thread 2 Completed");
		}).start();

//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

		System.out.println("Final Counter Value: " + sharedCounter.getCount());
	}
}
