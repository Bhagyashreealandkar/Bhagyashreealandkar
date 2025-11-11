package createThread;

public class CreateThreadExample3 {
	
	public static Object sharedObj = new Object(); 
	public static void main(String[] args) {

		System.out.println("Main thread Started");

		Runnable objRun1 = () -> {
			System.out.println("Thread 1 started");
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getState());
			System.out.println(sharedObj.hashCode());

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Thread 1 complete");
		};

		Runnable objRun2 = () -> {
			System.out.println("Thread 2 started");
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getState());
			System.out.println(sharedObj.hashCode());


			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Thread 2 complete");
		};

		Thread t1 = new Thread(objRun1, "Runnable Thread 1");
		t1.start();
		Thread t2 = new Thread(objRun1, "Runnable Thread 2");
		t2.start();

		System.out.println("Main thread ended");
		
		//both the obj accessing from the samememomry as its hashcode is printing same memory

	}

}
