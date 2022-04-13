package invoice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public Order searchByOrderNumber(int orderNum) {
        for (Order order: orders) {
            if (order.getOrderNumber() == orderNum) {
                return order;
            }
        }

        return null; // nothing found
    }

    String fileName = "data\\orders.dat";

    public void saveToFile() { 

        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(orders);

            file.close();
            out.close();

        } catch (IOException ex) {
            System.out.println("IOException in Saving to File");
        }

    }

    public void loadFromFile() throws IOException {

        try {

            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            ArrayList<Order> ordersFromFile = (ArrayList<Order>) in.readObject();

            for (Order order: ordersFromFile) {
                orders.add(order);
            }

        } catch (IOException ex) {
            System.out.println("IOException in Loading File");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }

    }

}
