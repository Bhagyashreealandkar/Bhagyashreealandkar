// Abstraction
package SolidDP;

interface FoodService {
    void serve(String food);
}

// Low-level class 1
class DineInFoodService implements FoodService {
    public void serve(String food) {
        System.out.println("🍽️ Serving at table: " + food);
    }
}

// Low-level class 2
class TakeAwayFoodService implements FoodService {
    public void serve(String food) {
        System.out.println("🥡 Packed for Takeaway: " + food);
    }
}

// High-level class
class RestaurantGood {
    private FoodService foodService;

    RestaurantGood(FoodService foodService) {
        this.foodService = foodService;
    }

    void orderFood(String food) {
        foodService.serve(food);
    }
}

public class DIPAfter {
    public static void main(String[] args) {
        RestaurantGood dineIn = new RestaurantGood(new DineInFoodService());
        dineIn.orderFood("Pizza");

        RestaurantGood takeAway = new RestaurantGood(new TakeAwayFoodService());
        takeAway.orderFood("Burger");
    }
}
