import invoice.Order;
import items.Drink;
import items.Size;

public class POS {
    public static void main(String[] args) {
        Order order = new Order();

        Drink smallPepsi = new Drink(45, "Pepsi (S)", 0.98, Size.SMALL);
        Drink mediumPepsi = new Drink(46, "Pepsi (M)", 0.94, Size.MEDIUM);
        Drink largePepsi = new Drink(47, "Pepsi (L)", 0.92, Size.LARGE);
        order.add(smallPepsi);
        order.add(mediumPepsi);
        order.add(largePepsi);

        System.out.println(order.completeOrder());
    }


}
