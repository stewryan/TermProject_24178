package invoice;

import items.*;
import javafx.scene.control.ComboBox;

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

    // TODO CORRECT
    public void updateOrder(int index, String desc, String ingredients, Size size, ComboBox cmbSelectedType) {
        // String ingredientsString = vi.getFldIngredients().getText();
        String[] ingredientsArray = ingredients.split(",");

        MenuItem itemToChange = items.get(index);
        itemToChange.setDescription(desc);
        if (cmbSelectedType.getSelectionModel().getSelectedIndex() == 0) {
            ((Drink) itemToChange).setSize(size);
        } else if (cmbSelectedType.getSelectionModel().getSelectedIndex() == 1) {
            ((FoodItem) itemToChange).setIngredients(ingredientsArray);
        } else if (cmbSelectedType.getSelectionModel().getSelectedIndex() == 2) {
            ((SideItem) itemToChange).setSize(size);
        }

        // itemToChange.setSize(size);
    }

    public void setOrderNumber(int orderNum) {
        this.orderNumber = orderNum;
    }

    public void add(MenuItem item) {
        items.add(item);
    }

    public void remove(MenuItem item) {
        items.remove(item);
    }

    public void remove(int index) {
        items.remove(index);
    }

    public ArrayList<MenuItem> getItems() {
        return this.items;
    }

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
        menu += "----------------------------------------\n";

        for (int i = 0; i < items.size(); i++) {
            menu += "($" + items.get(i).getPrice() + ") Item [" + i + "]: " + items.get(i) + "\n";
        }

        menu += "----------------------------------------\n";
        menu += "Total Price: " + this.getTotalPrice();

        return menu;
    }

    // public OrderList completeOrder() {
    // OrderList newReceipt = new OrderList(items, getTotalPrice());

    // return newReceipt;
    // }

}
