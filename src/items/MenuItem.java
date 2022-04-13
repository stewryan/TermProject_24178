package items;

import java.io.Serializable;

/**
 * A class that represents a generic menu item. (Not specifically food)
 * 
 * @author Ryan Stewart Apr 2022
 */
public abstract class MenuItem implements Serializable {
    
    private int id;
    private String description;
    protected double price;
    private double maxDiscount;
    public boolean isInStock;
    protected int calories;

    /**
     * 
     * No-arg constructor for items.MenuItem. Calls the multiple arg constructor with placeholder values.
     */
    public MenuItem() {
        this(1, "Unnamed Menu Item", 0.0);
    }

    /**
     * 
     * @param id the ID of the item on the menu 
     * @param desc the description of what the menu item is
     * @param discount the max discount the item can have
     */
    public MenuItem(int id, String desc, double discount) {
        this.id = id;
        this.description = desc;
        this.maxDiscount = discount;
        this.isInStock = true;
    }

    ///// Getter and setter methods ///////

    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return this.id;
    }

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

    public void setMaxDiscount(double discount) {
        this.maxDiscount = discount;
    }
    public double getDiscount() {
        return this.maxDiscount;
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
    public String toString() {
        return String.format("%s | Item %d", 
        this.getDescription(), this.getID());
    }

}