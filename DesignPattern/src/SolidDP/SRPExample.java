package SolidDP;

/*One class = One job.  Real-life example: Restaurant.
Sab kuch Restaurant class me hai → cooking, order, serving, payment.
Agar kal payment ka method change ho, ya serving ka process change ho → pura class edit karna padega.
If one person does everything, it becomes messy and hard to manage.

Why SRP is better here?
Waiter sirf order aur serving ka zimmedar hai.
Chef sirf cooking ka zimmedar hai.
Cashier sirf payment ka zimmedar hai.
👉 Ab agar kal payment online karna ho, to sirf Cashier class me change hoga.
👉 Agar cooking style change ho, to sirf Chef class me change hoga.
*/

//before
class RestaurantBad {
	void handleEverything() {
		System.out.println("Cooking food...");
		System.out.println("Serving food...");
		System.out.println("Generating bill...");
	}

	void cookFood() {
		System.out.println("Cooking food...");
	}

	void takeOrder() {
		System.out.println("Taking customer order...");
	}

	void collectPayment() {
		System.out.println("Collecting payment...");
	}
}

//After SRP
class Chef {
	void cookFood() {
		System.out.println("Chef is cooking food...");
	}
}

class Waiter {
	void serveFood() {
		System.out.println("Waiter is serving food...");
	}
}

class Cashier {
	void generateBill() {
		System.out.println("Cashier is generating bill...");
	}
}

public class SRPExample {
	public static void main(String[] args) {
		System.out.println("=== Before SRP ===");
		new RestaurantBad().handleEverything();

		// or
		new RestaurantBad().cookFood();

		System.out.println("\n=== After SRP ===");
		new Chef().cookFood();
		new Waiter().serveFood();
		new Cashier().generateBill();
	}
}
