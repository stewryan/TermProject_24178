package invoice;

import items.Drink;
import items.FoodItem;
import items.MenuItem;
import javafx.scene.control.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;

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

    File file = new File("data\\orders.dat");

    public void saveToFile() throws IOException {
        
        final int SIZE_ORDERNUM = 10;
        final int SIZE_DESCRIPTION = 35;
        final int SIZE_INGREDIENTS = 50;
        final int SIZE_SIZE = 6;
        final int SIZE_REC = Character.BYTES * (SIZE_ORDERNUM + SIZE_DESCRIPTION + SIZE_INGREDIENTS + SIZE_SIZE);

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {

            for (Order order: orders) {

                raf.writeChars(prepString(String.valueOf(order.getOrderNumber()), SIZE_ORDERNUM));

                for (int i = 0; i < order.getItems().size(); i++) {

                    MenuItem item = order.getItems().get(i);
                    raf.writeChars(prepString(item.getDescription(), SIZE_DESCRIPTION));
                    if (item instanceof Drink) {
                        raf.writeChars(prepString(String.valueOf(((Drink)item).getSize()), SIZE_SIZE));
                    }
                    if (item instanceof FoodItem) {
                        raf.writeChars(prepString(((FoodItem)item).getIngredients(), SIZE_INGREDIENTS));
                    }

                }

            }

        }

    }

    public static String prepString(String str, int size) {
        if (str.length() > size) {
            return str.substring(0, size);
        } else if (str.length() < size) {
            for (int i = 0; i < size - str.length(); i++) {
                str += " ";
            }
        }

        return str;
    } // method ends

}
