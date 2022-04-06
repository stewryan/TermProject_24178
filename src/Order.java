import java.util.ArrayList;

public class Order {

    public ArrayList<MenuItem> items = new ArrayList<>();

    public void add(MenuItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        String menu = "";

        for (int i = 0; i < items.size(); i++) {
            menu += "($" + items.get(i).getPrice() + ") Item [" + items.get(i).getID() + "]: " + items.get(i) + "\n";
        }

        return menu;
    }

    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice();
        }
        return total;
    }
    
}
