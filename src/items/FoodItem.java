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

    public void setIngredients(String[] items) {
        ingredients.clear();
        for (String item: items) {
            ingredients.add(item.toLowerCase());
        }
    }

    public void addIngredients(String[] items) {
        for (String item: items) {
            ingredients.add(item.toLowerCase());
        }
    }

    @Override
    public double getPrice() {
        return ValueCalculator.calculateFoodPrice(this);
    }
    public String getIngredients() {
        String output = "";
        for (String item: this.ingredients) {
            output += item + " ";
        }
        return output;
    }

    public ArrayList<String> getIngredientsArrayList() {
        return this.ingredients;
    }

    @Override
    public String toString() {

        return this.getDescription() + " | Contains " + this.getCalories() + " calories." + "\n\t Ingredients: " + this.getIngredients();

    }

}
