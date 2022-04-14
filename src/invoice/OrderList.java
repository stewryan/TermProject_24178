package invoice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * A class that models a list of records, that saves to a file once the program is done running.
 * When the program starts, it loads all the orders from the file and adds them to the arraylist.
 * 
 */
public class OrderList {
    
    private ArrayList<Order> orders = new ArrayList<>();
    private String fileName = "data\\orders.dat"; // the name of the file to save to/load from

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

    /**
     * Allows the user to search for an order by the number of the order
     * @param orderNum
     * @return
     */
    public Order searchByOrderNumber(int orderNum) {
        for (Order order: orders) {
            if (order.getOrderNumber() == orderNum) {
                return order;
            }
        }

        return null; // nothing found
    }

    /**
     * Saves the data in orders ArrayList to a file using Serialization.
     * 
     */
    public void saveToFile() { 

        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(orders); // write the arraylist to the file

            file.close();
            out.close();

        } catch (IOException ex) {
            System.out.println("IOException in Saving to File");
        }

    }

    /**
     * Loads the data from the file and places it into the orders ArrayList using Deserialization
     * 
     * @throws IOException
     */
    public void loadFromFile() throws IOException {

        try {

            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            ArrayList<Order> ordersFromFile = (ArrayList<Order>) in.readObject();

            // adding orders to the array from the file
            for (Order order: ordersFromFile) {
                if (!(order.getItems().isEmpty())) { // only load non-empty orders
                    orders.add(order);
                }
            }

        } catch (IOException ex) {
            System.out.println("IOException in Loading File");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }

    }

}
