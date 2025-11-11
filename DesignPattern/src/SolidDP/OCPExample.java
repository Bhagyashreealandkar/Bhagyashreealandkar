package SolidDP;

/*❌ Problem without OCP:
Aapke paas ek Payment class hai jo credit card se payment handle karti hai. 
Agar kal UPI ya PayPal add karna ho, toh aapko Payment class modify karna padega → purane code ko todne ka risk hoga.

✅ Solution with OCP:
Ek interface PaymentMethod banao. Har payment type ka alag class ho (CreditCard, UPI, PayPal). 
Ab naye method add karne ke liye bas naya class banao, purana code touch karne ki zaroorat nahi.*/

//before OCP
class PaymentBad {
	void pay(String type, double amount) {
		if (type.equals("CreditCard"))
			System.out.println("Paid " + amount + " using Credit Card (Bad)");
		else if (type.equals("UPI"))
			System.out.println("Paid " + amount + " using UPI (Bad)");
	}
}

//After OCP
interface Payment {
	void pay(double amount);
}

class CreditCardPayment implements Payment {
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using Credit Card");
	}
}

class UpiPayment implements Payment {
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using UPI");
	}
}

class Checkout  {
	void processPayment(Payment payment, double amount) {
		payment.pay(amount);
	}
}

public class OCPExample {
	public static void main(String[] args) {
		System.out.println("=== Before OCP ===");
		PaymentBad pb = new PaymentBad();
		pb.pay("CreditCard", 1000);
		pb.pay("UPI", 500);

		System.out.println("\n=== After OCP ===");
		Checkout checkout = new Checkout();
		checkout.processPayment(new CreditCardPayment(), 1500);
		checkout.processPayment(new UpiPayment(), 800);
	}
}
