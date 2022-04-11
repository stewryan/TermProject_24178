package invoice;

import items.MenuItem;

import java.util.ArrayList;

public class Order {

    //TODO Make this private after
    public ArrayList<MenuItem> items = new ArrayList<>();
    private int orderNumber;

    public int getOrderNumber() {
        return this.orderNumber;
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
        return total;
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
    //     OrderList newReceipt = new OrderList(items, getTotalPrice());

    //     return newReceipt;
    // }
    
}
