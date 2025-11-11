package SolidDP;
/*
Child class should behave like its parent without surprising the program.
//before
BirdBefore has fly().
OstrichBefore inherits BirdBefore, so according to OOP, Ostrich is a Bird.
But when we substitute BirdBefore with OstrichBefore → it breaks because ostrich cannot fly.This violates LSP.
Problem: Parent class promises something (fly()), but the child (OstrichBefore) cannot actually do it.


//after
Bird → common for all birds.
FlyableBird → only for birds that can fly.
Sparrow → can eat() and fly().
ostrich → only eat().
No surprises! If we use Bird, both Sparrow and Ostrich fit correctly.
If we use FlyableBird, only flying birds are allowed.

*/




// ================= BEFORE (Violates LSP) =================
class BirdBefore {
	void fly() {
		System.out.println("Bird is flying 🕊️");
	}
}

class OstrichBefore extends BirdBefore { // Ostrich is a bird but cannot fly
	@Override
	void fly() {
		throw new UnsupportedOperationException("Ostrich can't fly ❌");
	}
}

// ================= AFTER (Follows LSP) =================
interface Bird {
	void eat();
}

interface FlyableBird extends Bird {
	void fly();
}

class Sparrow implements FlyableBird {
	public void eat() {
		System.out.println("Sparrow eating seeds 🌾");
	}

	public void fly() {
		System.out.println("Sparrow flying 🕊️");
	}
}

class Ostrich implements Bird {
	public void eat() {
		System.out.println("Ostrich eating grass 🌿");
	}
}

// ================= DEMO CLASS =================
public class LSPExample {
	public static void main(String[] args) {
		System.out.println("=== BEFORE (Violating LSP) ===");
		BirdBefore bird = new OstrichBefore();
		try {
			bird.fly(); // ❌ Runtime error
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		
		
		
		System.out.println("\n=== AFTER (Following LSP) ===");
		Bird sparrow = new Sparrow();
		Bird ostrich = new Ostrich();

		sparrow.eat();
		ostrich.eat();

		FlyableBird flyingBird = new Sparrow();
		flyingBird.fly(); // ✅ Works fine
	}
}
