package invoice;

import items.MenuItem;

import java.util.ArrayList;

/**
 * invoice.Receipt is created when an invoice.Order.java has finished? Just ideas right now
 */
public class OrderList {
    
    private ArrayList<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public void remove(Order order) { 
        orders.remove(order);
    }

    public void remove(int index) {
        orders.remove(index);
    }

    public Order searchByOrderNumber(int orderNum) {
        for (Order order: orders) {
            if (order.getOrderNumber() == orderNum) {
                return order;
            }
        }

        return null; // nothing found
    }

    public void saveToFile() {
        // implement this method
    }

}
