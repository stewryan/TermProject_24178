import java.io.IOException;
import java.util.Optional;

import invoice.Order;
import invoice.OrderList;
import items.Drink;
import items.FoodItem;
import items.SideItem;
import items.Size;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;

public class MainViewController {

    private Order order; // the order that is being modified currently
    private OrderList list = new OrderList(); // instantiate a new OrderList
    private int currentVariableNumber; // the current "page" (the index of the order that is currently being viewed)

    private int lastItem;
    private int newOrderNumber;

    public Order getOrder() {
        return order;
    }

    EditView editView = new EditView();

    public MainViewController(MainView view){
        setView(view);
    }

    void setView(MainView view) {

        // Load the file into the ArrayList within OrderList when the program opens
        try {
            list.loadFromFile();
        } catch (IOException e1) {
            System.out.println("Caught IOException loading file at startup");
        }

        // Create the inital order (inside of the list), then refer to it using the list index
        list.add(new Order());
        order = list.getOrders().get(list.getOrders().size() - 1);

        // Set the order number only IF there are more orders behind it. Will default to 0 otherwise (declared in Order class)
        if (list.getOrders().size() > 1) {
            lastItem = list.getOrders().size() - 2;
            newOrderNumber = list.getOrders().get(lastItem).getOrderNumber() + 1;
            order.setOrderNumber(newOrderNumber);
        }

        // variable holding the current "page" for viewing records
        currentVariableNumber = list.getOrders().size() - 1;

        view.getOrderItemsDisplay().prefWidthProperty().bind(view.getOrderItemsDisplay().prefHeightProperty());
        view.getOrderItemsDisplay().setText(order.toString());

        /**
         * Set certain fields to DISABLED if a certain item is selected.
         * For example, if DRINK is seleceted, Ingredients field will be disabled.
         * If FOODITEM is selected, the Size field will be disabled.
         */
        view.getCmbItemType().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int selection = view.getCmbItemType().getSelectionModel().getSelectedIndex();
                if (selection == 0){
                    view.getFldIngredients().setDisable(true);
                    view.getFldIngredients().setPromptText("No ingredients available");
                    view.getCmbSize().setDisable(false);

                } else {
                    view.getFldIngredients().setDisable(false);
                    view.getFldIngredients().setPromptText("");
                    if (selection == 1) {
                        view.getCmbSize().setDisable(true);
                    } else {
                        view.getCmbSize().setDisable(false);
                    }
                }
            }
        });

        // This section is triggered by an ENTER key
        view.getFldItemName().setOnKeyPressed(e->{
            if( e.getCode() == KeyCode.ENTER ) {
                view.getBtnAdd().fire();
            }
        });
        view.getFldIngredients().setOnKeyPressed(e->{
            if( e.getCode() == KeyCode.ENTER ) {
                view.getBtnAdd().fire();
            }
        }); // end of section triggered by enter key

        // Add button
        view.getBtnAdd().setOnAction(e->{
            int selectedItem = view.getCmbItemType().getSelectionModel().getSelectedIndex(); // the item type in the drop down
            if (selectedItem == 0){ // drink

                //Grabbing variables from mainView
                String desc = view.getFldItemName().getText();
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
                    Drink drink = new Drink(desc, size);
                    order.add(drink);
                    view.getOrderItemsDisplay().setText(order.toString());
                }

            } else if (selectedItem == 1) {

                //Grabbing variables from mainView
                String desc = view.getFldItemName().getText();
                
                //Get ingredients split the hole string by comas and store them
                String ingredients = view.getFldIngredients().getText();
                String[] ingredientsArray = ingredients.split(",");

                // Create Food Item
                //If no description is entered alert info triggered, and nothing is added
                if (desc.trim() == "" || desc == null){
                    view.getAlertInfo().showAndWait();

                } else { //If it's not the case it's added
                    FoodItem food = new FoodItem(desc, new String[]{""});
                    food.setIngredients(ingredientsArray);
                    order.add(food);
                    view.getOrderItemsDisplay().setText(order.toString());
                }

            } else if (selectedItem == 2){ // side item

                //Grabbing variables from mainView
                String desc = view.getFldItemName().getText();
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
                    view.getAlertInfo().setContentText("Description must be entered!");
                    view.getAlertInfo().showAndWait();
                } else { //If it's not the case it's added
                    SideItem side = new SideItem(desc, size);
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

        // Open the edit window
        view.getBtnEdit().setOnAction(e->{
            editView.setOrder(order);
            editView.setHeight(180);
            editView.setWidth(250);
            editView.setView(view);
            editView.setTitle("Edit Order " + order.getOrderNumber());
            editView.setController(this);
            editView.show();
        }); // Closes Button Edit

        //Save and Exit
        view.getBtnSaveExit().setOnAction(e -> {
            list.saveToFile();
            System.exit(0);
        });

        //New Order
        view.getBtnNewOrder().setOnAction(e -> {
            // Check if the most recent order created is EMPTY. If it is empty, prompt the user and do not make a new order.
            Order lastOrder = list.getOrders().get(list.getOrders().size() - 1);
            if (lastOrder.getItems().size() < 1){
                view.getAlertInfo().setContentText("The LAST order is empty. Add to it first!");
                view.getAlertInfo().showAndWait();
            } else {
                list.add(new Order());
                order = list.getOrders().get(list.getOrders().size() - 1);

                lastItem = list.getOrders().size() - 2;
                newOrderNumber = list.getOrders().get(lastItem).getOrderNumber() + 1;
                order.setOrderNumber(newOrderNumber);

//            System.out.println(list.getOrders().get(lastItem));
                // Update the box on the right with the new order.
                view.getOrderItemsDisplay().setText(order.toString());
            }
        }); // Close btnNewOrder

        // Delete Order
        view.getBtnDeleteOrder().setOnAction(e-> {
            if (list.getOrders().size() > 1) {
                view.getAlertInfo().setAlertType(AlertType.CONFIRMATION);
                view.getAlertInfo().setContentText("Are you sure you want to delete order " + order.getOrderNumber() + "?");
                Optional<ButtonType> userRepsonse = view.getAlertInfo().showAndWait();
                if (userRepsonse.get() == ButtonType.OK) {
                    list.remove(order);
                    order = list.getOrders().get(--currentVariableNumber);
                    view.getOrderItemsDisplay().setText(order.toString());
                }
            } else {
                view.getAlertInfo().setAlertType(AlertType.ERROR);
                view.getAlertInfo().setContentText("This is the only order left!");
                view.getAlertInfo().show();
            }
        }); // end of deleteOrder

//     FIRST PREV NEXT LAST Buttons section
        view.getBtnFirst().setOnAction(e->{
            currentVariableNumber = 0;
            order = list.getOrders().get(0);
            //Update Line
            view.getOrderItemsDisplay().setText(order.toString());
        });

        // LAST recrod
        view.getBtnLast().setOnAction(e->{
            currentVariableNumber = list.getOrders().size() - 1;

            order = list.getOrders().get(list.getOrders().size() - 1);
            //Update Line
            view.getOrderItemsDisplay().setText(order.toString());
        });

        // Previous record
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

        // Next record
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

        view.getFldSearch().setPromptText("Enter an order ID");

        //TODO Search Function
        //Fired when Enter is in the field
        view.getFldSearch().setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.ENTER) {
                view.getBtnSearch().fire();
            }
        });

        view.getBtnSearch().setOnAction(e->{
            int searchNumber = Integer.parseInt(view.getFldSearch().getText());
            order = list.searchByOrderNumber(searchNumber);
            if (order != null) {
                view.getOrderItemsDisplay().setText(order.toString());
                view.getFldSearch().setText("");
            } else {
                view.getFldSearch().setText("");
                view.getAlertInfo().setContentText("Order not found, try searching again!");
                view.getAlertInfo().showAndWait();
            }
        });

    } // Set view Closes

}
