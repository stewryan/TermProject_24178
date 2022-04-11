package invoice;

import items.MenuItem;

import java.util.ArrayList;

public class Order {

    //TODO Make this private after
    public ArrayList<MenuItem> items = new ArrayList<>();
    
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

        for (int i = 0; i < items.size(); i++) {
            menu += "($" + items.get(i).getPrice() + ") Item [" + i + "]: " + items.get(i) + "\n";
        }

        return menu;
    }

    public Receipt completeOrder() {
        Receipt newReceipt = new Receipt(items, getTotalPrice());

        return newReceipt;
    }
    
}
