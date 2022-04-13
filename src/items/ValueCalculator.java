package items;

// not sure about this class, just having it here for now to figure out how to calcuate price of an item
public class ValueCalculator {
    
    private static final double FOOD_PRICE_MULTIPLIER = 1.75;
    private static final double DRINK_PRICE_MULTIPLIER = 0.50;

    private static final double ITEM_CALORIES_MULTIPLIER = 25;

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

    public static int calculateCalories(MenuItem item) {

        int calories = 0;
        
        if (item instanceof FoodItem) {
            calories = (int)(((FoodItem)item).getIngredientsArrayList().size() * 2 * ITEM_CALORIES_MULTIPLIER );
        } else if (item instanceof Drink) {
            switch (((Drink)item).getSize()) {
                case SMALL: 
                    calories = (int)(5 * ITEM_CALORIES_MULTIPLIER);
                break;
                case MEDIUM: 
                    calories = (int)(7.5 * ITEM_CALORIES_MULTIPLIER);
                break;
                case LARGE: 
                    calories = (int)(10 * ITEM_CALORIES_MULTIPLIER);
                break;
            }
        }

        return calories;

    }

}
