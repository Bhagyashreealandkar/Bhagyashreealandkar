package createThread;

public class RefThread {

	public static void main(String[] args) {

		ThreadLocal<Long> userIdThreadLocal = new ThreadLocal<>();

		Long userId = 12345L;
		Long userId1 = 56789L;

		// handle req in new thread
		Thread requestThread = new Thread(() -> {
			System.out.println("Started thread for " + userId);

			userIdThreadLocal.set(userId); // 👈 Store userId in ThreadLocal

			// Process my Logic
			// Database Call
			System.out.println("Completed logic for " + userId);
			
			System.out.println("completed logic for " + userIdThreadLocal.get());

			// Good coding practice to remove threadLocal object
			userIdThreadLocal.remove(); // 👈 Clean up ThreadLocal
			System.out.println("Removed " + userId);
		});
		
		Thread requestThread1 = new Thread(() -> {
			System.out.println("Started thread for " + userId1);

			userIdThreadLocal.set(userId1);
			System.out.println("Completed logic for " + userIdThreadLocal.get());

			userIdThreadLocal.remove();
			System.out.println("Removed " + userId1);
		});

		//requestThread.start();
		//requestThread1.start();
		
		
		
		InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

		Thread objThread3 = new Thread(() -> {
			inheritableThreadLocal.set("Instagram"); // 👈 Set value in parent thread
			userIdThreadLocal.set(1234567L);
			System.out.println("parent"+userIdThreadLocal.get());//value got printed cuz id set for local obj in parent and called in parent

			Thread objThread4 = new Thread(() -> {
				System.out.println("in"+inheritableThreadLocal.get()); // 👈 Access in child thread
				System.out.println("in"+userIdThreadLocal.get());//value not got printed cuz id set for local obj in parent and called in child , but for inheritableThreadLocal  it will print parents value as weell
			});

			objThread4.start();
		});
		
		objThread3.start();

	}

}
