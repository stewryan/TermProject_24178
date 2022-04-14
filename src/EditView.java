import invoice.Order;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The edit window that allows a user to edit specific MenuItems in an order.
 */
public class EditView extends Stage {

    // Items inside
    Label lblTitle = new Label("EDIT A PRODUCT");
    Label itemEditDisplay = new Label();
    TextField txtItemId = new TextField();
    Button btnEditProduct = new Button("MODIFY");
    Button btnBack = new Button("BACK");
    Button btnDelete = new Button("DELETE");

    // Order To deal with
    Order order;

    // View to deal with
    MainView view;

    // Controller to deal with
    MainViewController controller;

    public void setController(MainViewController controller) {
        this.controller = controller;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setView(MainView view) {
        this.view = view;
    }

    // Method to populate the Hboxes and Vboxes
    // speficied above
    public EditView() {
        super();
        // code to create components and do all the layout
        VBox pane = new VBox(10);

        // HBox Options
        HBox rowOptions = new HBox();

        rowOptions.setSpacing(20);
        rowOptions.getChildren().addAll(btnEditProduct, btnDelete, btnBack);

        rowOptions.setAlignment(Pos.CENTER);

        // Not so sure what the hell is this but If it doesn't have this it doesn't work
        pane.getChildren().addAll(lblTitle, itemEditDisplay, txtItemId, rowOptions);

        // Disabled Display
        itemEditDisplay.setDisable(true);
        itemEditDisplay.setText("Insert ID Bellow");
        itemEditDisplay.setMinHeight(30);
        // itemEditDisplay.prefHeightProperty().bind(itemEditDisplay.prefWidthProperty());

        Scene scene = new Scene(pane, 200, 200);
        this.setScene(scene);
        this.setTitle("Title of Second Window");
        // use initModality if you want this Stage to block the app
        this.initModality(Modality.WINDOW_MODAL);
        btnBack.setOnAction(e -> {
            this.close();
        });

        btnDelete.setOnAction(e -> {

            try {
                int idToDelete = Integer.parseInt(txtItemId.getText());
                order.getItems().remove(idToDelete);
                view.getOrderItemsDisplay().setText(order.toString());

            } catch (Exception ex) {
                view.getAlert().setContentText("Item not found. Use the number in Item [#] in the order list.");
                view.getAlert().showAndWait();
            }
        });

        /***
         * Modify Section
         */
        // HBox and Vboxes for Modifying product
        // Type Item and respective Drop down list

        txtItemId.setPromptText("Enter an item number");
        // Item name with it's text field
        Label lblItemName = new Label("Item Name");
        TextField txtItemName = new TextField();

        // Ingredients label and it's text field
        Label lblIngredients = new Label("Ingredients");
        TextField txtIngredients = new TextField();


        // Add Button
        Button btnConfirm = new Button("CONFIRM");
        /**
         * Modify Section Ends
         */

        // BottomPane divided into left Side and Right side
        VBox paneModify = new VBox(10);

        // Left side Content

        HBox rowItemName = new HBox(lblItemName, txtItemName);
        rowItemName.setAlignment(Pos.CENTER);
        rowItemName.setSpacing(2);

        // Ingredients row show if it's food not drink
        HBox rowIngredients = new HBox(lblIngredients, txtIngredients);
        rowIngredients.setAlignment(Pos.CENTER);
        rowIngredients.setSpacing(2);


        HBox rowConfirmButton = new HBox(btnConfirm);
        rowConfirmButton.setAlignment(Pos.CENTER);

        paneModify.getChildren().addAll(rowItemName, rowIngredients, rowConfirmButton);

        AtomicBoolean notAdded = new AtomicBoolean(true);
        btnEditProduct.setOnAction(e -> {
            if (notAdded.get() == true) {
                pane.getChildren().add(paneModify);
                controller.editView.setHeight(300);
                notAdded.set(false);
            } else {
                pane.getChildren().remove(paneModify);
                controller.editView.setHeight(180);
                notAdded.set(true);
            }

        });

        btnConfirm.setOnAction(e -> {
            // Ingredients
            String ingredients = txtIngredients.getText();

            try {

                int idToModify = Integer.parseInt(txtItemId.getText());
                String newDesc = txtItemName.getText();

                
                if (newDesc.trim() == "" || newDesc == null) {
                    view.getAlert().showAndWait();
                } else { // If it's not the case it's updated
                    order.updateOrder(idToModify, newDesc, ingredients);
                    view.getOrderItemsDisplay().setText(order.toString());
                }
            } catch (Exception ex) {
                view.getAlert().setContentText("Fields Can't be Empty");
                view.getAlert().showAndWait();
            }

        });

        btnEditProduct.requestFocus();
    }

}
