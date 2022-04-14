package items;

import java.io.Serializable;

/**
 * A class that represents a generic menu item. (Not specifically food)
 * 
 * @author Ryan Stewart Apr 2022 
 * @author Marcelo Geldres Apr 2022
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

    /**
     * 
     * @param desc The description/name of the item
     */
    public void setDescription(String desc) {
        this.description = desc;
    }
    /**
     * 
     * @return the items description
     */
    public String getDescription() {
        return this.description;
    }
    
    public abstract double getPrice(); // must be overridden and calculated using ValueCalculator.java

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