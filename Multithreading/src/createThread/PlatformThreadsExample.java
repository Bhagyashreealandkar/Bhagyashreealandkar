package createThread;

//import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

public class PlatformThreadsExample {

	//private static HttpClient client = HttpClient.newHttpClient(); // Just for simulation

	public static void main(String[] args) throws InterruptedException {
		final int numberOfThreads = 10_000;

		List<Thread> listThreads = new ArrayList<>();

		Runnable objRunnable = new Runnable() {
			@Override
			public void run() {
				// Simulate fetching data from an API
				System.out.println("Fetching data from API");

				try {
					Thread.sleep(10000); // Simulate delay
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Data fetched from API");
			}
		};

		for (int i = 0; i < numberOfThreads; i++) {
			Thread thread = new Thread(objRunnable);

			// Platform threads typically consume more resources (stack, memory)
			thread.setDaemon(true); // Optional: allows JVM to exit if only daemon threads are left
			thread.setName("Thread " + i);
			thread.start();

			String str = String.format("Thread number %s", i);
			System.out.println(str);

			listThreads.add(thread);
		}

		// Wait for all threads to finish
		for (Thread thr : listThreads) {
			thr.join(); // Wait for each thread to complete
			System.out.println(thr.getName() + " Completed");
		}
	}
}
