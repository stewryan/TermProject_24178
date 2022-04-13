import java.io.IOException;

import com.sun.java.accessibility.util.EventID;
import invoice.Order;
import invoice.OrderList;
import items.Drink;
import items.FoodItem;
import items.Size;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class POS extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView view = new MainView();
        MainViewController controller = new MainViewController(view);

        // Insert Controller here
        Scene scene = new Scene(view.getView());
        primaryStage.setTitle("POS MAIN MENU");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {

        OrderList list = new OrderList();
        try {
            //list.saveToFile();
            list.loadFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Order order = new Order();
        Order order2 = new Order();
        if (!list.getOrders().isEmpty()) {
            order.setOrderNumber(list.getOrders().get(list.getOrders().size() - 1).getOrderNumber() + 1);
            list.add(order);
            order2.setOrderNumber(list.getOrders().get(list.getOrders().size() - 1).getOrderNumber() + 1);
            list.add(order2);
        }

        Drink smallPepsi = new Drink(45, "Pepsi (S)", 0.98, Size.SMALL);
        Drink mediumPepsi = new Drink(46, "Pepsi (M)", 0.94, Size.MEDIUM);
        Drink largePepsi = new Drink(47, "Pepsi (L)", 0.92, Size.LARGE);
        order.add(smallPepsi);
        order.add(mediumPepsi);
        order.add(largePepsi);
        FoodItem burger = new FoodItem(0, "Hamburger", 0.0, new String[] { "Patty, Bun, Tomato, Lettuce" });
        order.add(burger);
        // list.add(order);

        System.out.println(list.getOrders());

        launch();

    }

}
