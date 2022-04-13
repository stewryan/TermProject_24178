package items;

// not sure about this class, just having it here for now to figure out how to calcuate price of an item
public class PriceCalculator {
    
    private static final double FOOD_PRICE_MULTIPLIER = 1.75;
    private static final double DRINK_PRICE_MULTIPLIER = 0.50;

    public static double calculateFoodPrice(FoodItem item) {

        double price = 0.99;
        price += item.getIngredientsArrayList().size() * FOOD_PRICE_MULTIPLIER;
        return Math.round(price * 100.0) / 100.0; // round to 2 decimals

    }

    public static double calculateDrinkprice(Drink drink) { 

        double price = 1.99;
        switch (drink.getSize()) {
            case SMALL:
                price += 0.99 * DRINK_PRICE_MULTIPLIER;
            break;
            case MEDIUM:
                price += 0.99 * (DRINK_PRICE_MULTIPLIER + 1.5);
            break;
            case LARGE:
            price += 0.99 * (DRINK_PRICE_MULTIPLIER + 2.5);
            break;
        }
        return Math.round(price * 100.0) / 100.0; // round to 2 decimals

    }

}
