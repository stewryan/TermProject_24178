package items;

import java.util.ArrayList;

/**
 * A class that reprents a general food item on the menu, can be nearly anything (e.g. sandwich, burger, salad, pizza)
 * 
 * @author Ryan Stewart Apr 2022
 */
public class FoodItem extends MenuItem {

    protected ArrayList<String> ingredients = new ArrayList<>(); // stores all the ingredients, all in lower case

    public FoodItem(int id, String desc, double discount, String[] ingredients) {
        super(id, desc, discount);
        this.addIngredients(ingredients);
    }

    /**
     * SET the ingredients of the Food Item. Will first clear ANY ingredients already existing.
     * @param items
     */
    public void setIngredients(String[] items) {
        ingredients.clear();
        for (String item: items) {
            ingredients.add(item.toLowerCase());
        }
    }

    /**
     * Add new items to the food item
     * @param items
     */
    public void addIngredients(String[] items) {
        for (String item: items) {
            ingredients.add(item.toLowerCase());
        }
    }

    /**
     * Get the generated price of the food item. Value is calcualted mainly using the number of ingredients.
     */
    @Override
    public double getPrice() {
        return ValueCalculator.calculateFoodPrice(this);
    }

    /**
     * 
     * @return ingredients as one string separated by spaces
     */
    public String getIngredients() {
        String output = "";
        for (String item: this.ingredients) {
            output += item + " ";
        }
        return output;
    }

    /**
     * 
     * @return the actual ArrayList of ingredients.
     */
    public ArrayList<String> getIngredientsArrayList() {
        return this.ingredients;
    }

    @Override
    public String toString() {

        return this.getDescription() + " | Contains " + this.getCalories() + " calories." + "\n\t Ingredients: " + this.getIngredients();

    }

}
