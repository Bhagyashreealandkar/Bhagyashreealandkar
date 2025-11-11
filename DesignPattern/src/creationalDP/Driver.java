package creationalDP;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

	public static void main(String[] args) {
//		//member1
//		TVSet tvset1ForMember1 = new TVSet();
//		//member2
//		TVSet tvset1ForMember2 = new TVSet();

//		// member1
//		TVSet tvset1ForMember1 = TVSet.getTvSetInstance();
//		// member2
//		TVSet tvset1ForMember2 = TVSet.getTvSetInstance();
//
//		System.out.println(tvset1ForMember1);
//		System.out.println(tvset1ForMember1);

		//multithreading
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(() -> TVSet.getTvSetInstance());
		executor.execute(() -> TVSet.getTvSetInstance());

	}

}
