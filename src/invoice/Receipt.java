package invoice;

import items.MenuItem;

import java.util.ArrayList;

/**
 * invoice.Receipt is created when an invoice.Order.java has finished? Just ideas right now
 */
public class Receipt {
    
    private ArrayList<MenuItem> items = new ArrayList<>();
    private int orderNumber; // static counter starting at 0, change to read from last receipt in file later
    private double totalPrice;

    public Receipt(ArrayList<MenuItem> items, double price) {
        
        for (MenuItem item: items) {
            this.items.add(item);
        }

        this.orderNumber = 0; // set in code based on reading file of previous orders?
        this.totalPrice = price;

    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(int orderNum) { 
        this.orderNumber = orderNum;
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
        menu += "Total Price: " + this.totalPrice;

        return menu;
    }

}
