package creationalDP;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Subscriber {
	void update(String videoTitle);
}

//Concrete Observer
class User implements Subscriber {
	private String name;

	User(String name) {
		this.name = name;
	}

	@Override
	public void update(String videoTitle) {
		System.out.println(name + " received notification -> New Video: " + videoTitle);
	}
}

// Subject Class (YouTube Channel)
class YouTubeChannel {
	private List<Subscriber> subscribers = new ArrayList<>();
	private String channelName;

	YouTubeChannel(String channelName) {
		this.channelName = channelName;
	}

	void subscribe(Subscriber s) {
		subscribers.add(s);
	}

	void unsubscribe(Subscriber s) {
		subscribers.remove(s);
	}

	void uploadVideo(String videoTitle) {
		System.out.println(channelName + " uploaded: " + videoTitle);
		notifySubscribers(videoTitle);
	}

	private void notifySubscribers(String videoTitle) {
		for (Subscriber s : subscribers) {
			s.update(videoTitle);
		}
	}
}

// Main
public class YouTubeObserverExample {
	public static void main(String[] args) {
		YouTubeChannel channel = new YouTubeChannel("TechWorld");

		Subscriber u1 = new User("Alice");
		Subscriber u2 = new User("Bob");
		Subscriber u3 = new User("Charlie");

		channel.subscribe(u1);
		channel.subscribe(u2);
		channel.subscribe(u3);

		channel.uploadVideo("Observer Design Pattern Explained!");
		channel.uploadVideo("Java Streams Tutorial");
	}
}
