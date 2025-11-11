// Low-level class
package SolidDP;

class DineInService {
    void serve(String food) {
        System.out.println("🍽️ Serving at table: " + food);
    }
}

// High-level class depends on low-level directly
class Restaurantworst {
    private DineInService dineIn = new DineInService();

    void orderFood(String food) {
        dineIn.serve(food);  // tightly coupled
    }
}

public class DIPBefore {
    public static void main(String[] args) {
        Restaurantworst restaurant = new Restaurantworst();
        restaurant.orderFood("Pizza");
    }
}
