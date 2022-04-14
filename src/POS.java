import java.io.IOException;

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

        launch();

    }

}
