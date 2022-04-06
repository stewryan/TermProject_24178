package items;

import java.util.ArrayList;

public abstract class FoodItem extends MenuItem {

    protected ArrayList<String> ingredients = new ArrayList<>(); // stores all the ingredients, all in lower case

    public FoodItem(int id, String desc, double price, double discount, String[] ingredients, int calories) {
        super(id, desc, price, discount, calories);
        this.addIngredients(ingredients);
    }

    public void addIngredients(String[] items) {
        for (String item: items) {
            ingredients.add(item.toLowerCase());
        }
    }

    // Overloaded methods, can use either string or index of the ingredient
    public void removeIngredient(String itemName) {
        ingredients.remove(itemName.toLowerCase());
    }
    public void removeIngredient(int index) {
        ingredients.remove(index);
    }
    public String getIngredients() {
        String output = "";
        for (String item: this.ingredients) {
            output += item + " ";
        }
        return output;
    }

}