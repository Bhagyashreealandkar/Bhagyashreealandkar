package createThread;

class MyThread extends Thread {

	public void run() {
		System.out.println("Thread 1 is running");
	}
}

public class CreateThreadExample1 {
	public static void main(String[] args) {
		
		System.out.println("Main thread Started");

		Thread t2 = new Thread(() -> {
			System.out.println("Thread 2 is running");
		});
		t2.start();

		
		Runnable objRun2 = () -> {
			System.out.println("Thread 3 started");
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getState());
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Thread 3 started");
		};

		Thread t4 = new Thread(objRun2, "Runnable Thread");
		t4.setDaemon(true);
		t4.start();
		
		System.out.println("Main thread ended");
		
		//our program will keep running until all thread(eg thread3) gets complete eexecution
		/*
		 * but sometimes we hv to run our thread in bg w/o impacting main thread bcuz
		 * usecase can be if u want to do gc or u just want to monitor ur res or u want
		 * to do some logging for that task u dnt want ur main thread to wait for the
		 * other thread for that there is deamoon thread concept in java
		 */

		
		//op
//		Main thread Started
//		Main thread ended
//		Thread 3 started
//		Runnable Thread
//		RUNNABLE
//		Thread 2 is running
		
		
		//see main thread didt waited to end thread
	}

}
