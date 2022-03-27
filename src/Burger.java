public class Burger extends FoodItem{
    
    public Burger() {
        super(1, "A burger", 12.99, 0.00, new String[]{"Bun", "Patty", "Lettuce", "Cheese"}, 0);
    }

    public Burger(int id, String desc, double price, double discount, String[] ingredients, int calories) {
        super(id, desc, price, discount, ingredients, calories);
    }

}
