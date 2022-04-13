package items;

import java.io.Serializable;

/**
 * A class that represents a generic menu item. (Not specifically food)
 * 
 * @author Ryan Stewart Apr 2022
 */
public abstract class MenuItem implements Serializable {
    
    private String description;
    protected double price;
    public boolean isInStock;
    protected int calories;

    /**
     * 
     * No-arg constructor for items.MenuItem. Calls the 1 arg constructor with placeholder values.
     */
    public MenuItem() {
        this("Unnamed Menu Item");
    }

    /**
     * 
     * @param desc the description of what the menu item is
     */
    public MenuItem(String desc) {
        this.description = desc;
        this.isInStock = true;
    }

    ///// Getter and setter methods ///////

    public void setDescription(String desc) {
        this.description = desc;
    }
    public String getDescription() {
        return this.description;
    }
    

    // public void setPrice(double price) {
    //     this.price = price;
    // }
    public double getPrice() {
        return this.price;
    }

    /**
     * 
     * @return the generated value of calories. If it is a Food Item, will be based off of number of ingredients
     * If it is a Drink Item, will be based off Size
     */
    public int getCalories() {
        return ValueCalculator.calculateCalories(this);
    }

    @Override
    public abstract String toString();

}