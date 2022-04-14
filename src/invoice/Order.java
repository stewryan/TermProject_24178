package invoice;

import items.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class that resembles an order (Record) in the program
 * 
 */
public class Order implements Serializable {

    private ArrayList<MenuItem> items = new ArrayList<>();
    private int orderNumber = 0; // default order # at 0

    public int getOrderNumber() {
        return this.orderNumber;
    }

    /**
     * Updates the order, used in the "Edit" window of the menu
     * @param index
     * @param desc
     * @param ingredients
     * @param size
     * @param cmbSelectedType
     */
    public void updateOrder(int index, String desc, String ingredients) {

        MenuItem itemToChange = items.get(index);
        itemToChange.setDescription(desc);

        //Array Creation for Split and Usage
        String[] ingredientsArray = ingredients.split(",");

        //Setting the specific conditions that updating will follow in case of each item.
        if (itemToChange instanceof FoodItem) {
            ((FoodItem) itemToChange).setIngredients(ingredientsArray);
        }

    }

    /**
     * 
     * @param orderNum the number to set the order number to
     */
    public void setOrderNumber(int orderNum) {
        this.orderNumber = orderNum;
    }

    /**
     * 
     * @param item to add to the order
     */
    public void add(MenuItem item) {
        items.add(item);
    }

    /**
     * 
     * @param item to remove from the order 
     */
    public void remove(MenuItem item) {
        items.remove(item);
    }

    /**
     * 
     * @param index of the item to remove from the order
     */
    public void remove(int index) {
        items.remove(index);
    }

    /**
     * 
     * @return the items ArrayList of the order
     */
    public ArrayList<MenuItem> getItems() {
        return this.items;
    }

    /**
     * 
     * @return the total price of all the items in the order added together
     */
    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        String menu = "";

        menu += "invoice.Receipt for invoice.Order Number " + orderNumber + "\n";
        menu += "────────────────────────────────────────────────\n";
        

        for (int i = 0; i < items.size(); i++) {
            menu += "($" + items.get(i).getPrice() + ") Item [" + i + "]: " + items.get(i) + "\n";
        }

        menu += "────────────────────────────────────────────────\n";
        menu += "Total Price: $" + this.getTotalPrice();

        return menu;
    }

}
