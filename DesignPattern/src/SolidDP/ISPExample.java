package SolidDP;
/*
Problem:
Human needs both work() and eat() → okay.
Robot only needs work(), but still must implement eat().
Robot’s eat() throws an exception → violates ISP.
Interface is too fat → it forces classes to depend on methods they don’t need.
👉 Result: Tight coupling + unnecessary code + possible runtime errors.


Solution:
Interfaces are segregated into smaller, specific ones.
Human → implements both Workable + Eatable (needs both).
Robot → only implements Workable.
*/



//=== BEFORE ISP ===
interface WorkerBad {
	void work();
	void eat(); // Robots don’t need this, but still forced
}

class HumanWorkerBad implements WorkerBad {
	public void work() {
		System.out.println("Human is working (Bad)");
	}

	public void eat() {
		System.out.println("Human is eating lunch (Bad)");
	}
}

class RobotWorkerBad implements WorkerBad {
	public void work() {
		System.out.println("Robot is working (Bad)");
	}

	public void eat() {
		// Problem: Robot doesn’t eat, but must implement
		throw new UnsupportedOperationException("Robot doesn't eat! (Bad)");
	}
}

//=== AFTER ISP ===
interface Workable {
	void work();
}

interface Eatable {
	void eat();
}

class HumanWorker implements Workable, Eatable {
	public void work() {
		System.out.println("Human is working");
	}

	public void eat() {
		System.out.println("Human is eating lunch");
	}
}

class RobotWorker implements Workable {
	public void work() {
		System.out.println("Robot is working");
	}
}

//=== MAIN CLASS ===
public class ISPExample {
	public static void main(String[] args) {
		System.out.println("=== Before ISP ===");
		WorkerBad humanBad = new HumanWorkerBad();
		humanBad.work();
		humanBad.eat();

		WorkerBad robotBad = new RobotWorkerBad();
		robotBad.work();
		try {
			robotBad.eat(); // Will throw error
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n=== After ISP ===");
		Workable human = new HumanWorker();
		Eatable humanEat = new HumanWorker();
		human.work();
		humanEat.eat();

		Workable robot = new RobotWorker();
		robot.work();
	}
}
