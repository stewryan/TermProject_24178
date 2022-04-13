import invoice.Order;
import invoice.OrderList;
import items.Drink;
import items.FoodItem;
// import items.Fries;
import items.SideItem;
import items.Size;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainViewController {

    private Order order;
    private OrderList list = new OrderList();
    private int currentVariableNumber;

    public Order getOrder() {
        return order;
    }

    EditView editView = new EditView();

    public MainViewController(MainView view){
        setView(view);
    }

    void setView(MainView view){

        list.add(new Order());
        order = list.getOrders().get(list.getOrders().size() - 1);

        currentVariableNumber = list.getOrders().size();

        view.getOrderItemsDisplay().prefWidthProperty().bind(view.getOrderItemsDisplay().prefHeightProperty());

        view.getCmbItemType().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (view.getCmbItemType().getSelectionModel().getSelectedIndex() == 0){
                    view.getFldIngredients().setDisable(true);
                    view.getFldIngredients().setPromptText("No ingredients available");

                } else {
                    view.getFldIngredients().setDisable(false);
                    view.getFldIngredients().setPromptText("");
                }
            }
        });

        view.getBtnAdd().setOnAction(e->{
            if (view.getCmbItemType().getSelectionModel().getSelectedIndex() == 0){

                //Grabbing variables from mainView
                int id = 45;
                String desc = view.getFldItemName().getText();
                double discount = 0.98;
                Size size;
                switch (view.getCmbSize().getSelectionModel().getSelectedIndex()) {
                    case 0:
                        size = Size.SMALL;
                        break;
                    case 1:
                        size = Size.MEDIUM;
                        break;
                    case 2:
                        size = Size.LARGE;
                        break;
                    default:
                        size = Size.SMALL;
                        break;
                }

                //If no description is entered alert info triggered, and nothing is added
                if (desc.trim() == "" || desc == null){
                    view.getAlertInfo().showAndWait();
                } else { //If it's not the case it's added
                    Drink drink = new Drink(id, desc, discount, size);
                    order.add(drink);
                    view.getOrderItemsDisplay().setText(order.toString());
                }

            } else if (view.getCmbItemType().getSelectionModel().getSelectedIndex() == 1){

                //Grabbing variables from mainView
                int id = 45;
                String desc = view.getFldItemName().getText();
                double discount = 0.98;
                Size size;
                switch (view.getCmbSize().getSelectionModel().getSelectedIndex()) {
                    case 0:
                        size = Size.SMALL;
                        break;
                    case 1:
                        size = Size.MEDIUM;
                        break;
                    case 2:
                        size = Size.LARGE;
                        break;
                    default:
                        size = Size.SMALL;
                        break;
                }

                //Get ingredients split the hole string by comas and store them
                String ingredients = view.getFldIngredients().getText();
                String[] ingredientsArray = ingredients.split(",");

                // Create Food Item
                //If no description is entered alert info triggered, and nothing is added
                if (desc.trim() == "" || desc == null){
                    view.getAlertInfo().showAndWait();

                } else { //If it's not the case it's added
                    FoodItem food = new FoodItem(id, desc, discount, new String[]{""});
                    food.setIngredients(ingredientsArray);
                    order.add(food);
                    view.getOrderItemsDisplay().setText(order.toString());
                }

            } else if (view.getCmbItemType().getSelectionModel().getSelectedIndex() == 2){

                //Grabbing variables from mainView
                int id = 45;
                String desc = view.getFldItemName().getText();
                double discount = 0.98;
                Size size;
                switch (view.getCmbSize().getSelectionModel().getSelectedIndex()) {
                    case 0:
                        size = Size.SMALL;
                        break;
                    case 1:
                        size = Size.MEDIUM;
                        break;
                    case 2:
                        size = Size.LARGE;
                        break;
                    default:
                        size = Size.SMALL;
                        break;
                }
                //
                String ingredients = view.getFldIngredients().getText();
                String[] ingredientsArray = ingredients.split(",");

                if (desc.trim() == "" || desc == null){
                    view.getAlertInfo().showAndWait();

                } else { //If it's not the case it's added
                    SideItem side = new SideItem(45, desc, discount, size);
                    side.addIngredients(ingredientsArray);
                    order.add(side);
                    view.getOrderItemsDisplay().setText(order.toString());
                }
            }

            //Reseting all variables to nothing for next add
            view.getCmbItemType().getSelectionModel().select(-1);
            view.getFldItemName().setText("");
            view.getFldIngredients().setText("");
            view.getCmbSize().getSelectionModel().selectFirst();

        });//Closes Button Add

        view.getBtnEdit().setOnAction(e->{
            editView.setOrder(order);
            editView.setView(view);
            editView.setController(this);
            editView.show();

        }); // Closes Button Edit
        editView.setHeight(150); // Temporary first height

        //TODO de-comment saveToFile();
        //Save and Exit
        view.getBtnSaveExit().setOnAction(e -> {
//            orderList.saveToFile();
            System.exit(0);
        });

        //New Order
        view.getBtnNewOrder().setOnAction(e -> {
            if (order.getItems().size() < 1){
                view.getAlertInfo().setContentText("Empty orders Can't be added");
                view.getAlertInfo().showAndWait();
            } else {
                list.add(new Order());
                order = list.getOrders().get(list.getOrders().size() - 1);

                int lastItem = list.getOrders().size() - 2;
                int newOrderNumber = list.getOrders().get(lastItem).getOrderNumber() + 1;
                order.setOrderNumber(newOrderNumber);

//            System.out.println(list.getOrders().get(lastItem));
                view.getOrderItemsDisplay().setText(order.toString());
            }
        }); // Close btnNewOrder

//     FIRST PREV NEXT LAST Buttons section
        view.getBtnFirst().setOnAction(e->{
            currentVariableNumber = 0;
            order = list.getOrders().get(0);
            //Update Line
            view.getOrderItemsDisplay().setText(order.toString());
        });

        view.getBtnLast().setOnAction(e->{
            currentVariableNumber = list.getOrders().size() - 1;

            order = list.getOrders().get(list.getOrders().size() - 1);
            //Update Line
            view.getOrderItemsDisplay().setText(order.toString());
        });

        view.getBtnPrev().setOnAction(e->{
            if (currentVariableNumber > 0){
                --currentVariableNumber;
                order = list.getOrders().get(currentVariableNumber);
                //Update Line
                view.getOrderItemsDisplay().setText(order.toString());
            } else {
                view.getAlertInfo().setContentText("This is the first record");
                view.getAlertInfo().showAndWait();
            }
        });

        view.getBtnNext().setOnAction(e->{
            if (currentVariableNumber < list.getOrders().size() - 1){
                ++currentVariableNumber;
                order = list.getOrders().get(currentVariableNumber);
                //Update Line
                view.getOrderItemsDisplay().setText(order.toString());
            }  else {
                view.getAlertInfo().setContentText("This is the last record");
                view.getAlertInfo().showAndWait();
            }

        });
    } // Set view Closes

}
