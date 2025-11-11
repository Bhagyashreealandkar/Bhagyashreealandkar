package createThread;

class MyThread1 extends Thread {

	public void run() {
		System.out.println("Thread 1 is running");
	}
}

public class CreateThreadExample2 {
	public static void main(String[] args) {

		// it will not do anything it will just start
		// Thread t1 = new Thread();
		// t1.start();

		
		
		
		// 1.legacy way
		MyThread1 t1 = new MyThread1();
		t1.start();

		// 2.lambda expresion
		Thread t2 = new Thread(() -> {
			System.out.println("Thread 2 is running");
		});
		t2.start();

		
		
		//Runnable - we cannont create obj of runnable as it is interface we have provide impl in thread
		Runnable objRun1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 3 is running");

			}
		};
		Thread t3 = new Thread(objRun1, "Runnable Thread");
		t3.start();

		
		//stream 
		Runnable objRun2 = () -> {
			System.out.println("Thread 4 is running");
		};

		Thread t4 = new Thread(objRun2, "Runnable Thread");
		t4.start();

	}

}
