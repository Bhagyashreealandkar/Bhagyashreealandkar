package createThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Producer class
class ProducerBlockingQueue implements Runnable {
	private BlockingQueue<Integer> queue;

	public ProducerBlockingQueue(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 100; i++) {
				Thread.sleep(1000); // Simulating work
				queue.put(i); // Blocks if queue is full
				System.out.println("Produced: " + i);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

// Consumer class
class ConsumerBlockingQueue implements Runnable {
	private BlockingQueue<Integer> queue;

	public ConsumerBlockingQueue(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Integer item = queue.take(); // Blocks if queue is empty
				System.out.println("Consumed: " + item);
				Thread.sleep(2000); // Simulating work
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

// Main class
public class BlockingQueueExample {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // Capacity 5

		ProducerBlockingQueue producer = new ProducerBlockingQueue(queue);
		ConsumerBlockingQueue consumer = new ConsumerBlockingQueue(queue);

		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);

		producerThread.start();
		consumerThread.start();
	}
}
