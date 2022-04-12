import com.sun.tools.javac.Main;
import invoice.Order;
import items.FoodItem;
import items.Size;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Collection;

public class EditView extends Stage {

    //Items inside
    /**
     * Pls don't change this weird lines, I have no idea of why, but this works.
     *
     * javafx.scene.control.  <- This for ctrl+c ctrl+v when needed
     *
     */
    Label lblTitle = new Label("EDIT A PRODUCT");
    Label itemEditDisplay = new Label();
    TextField fldIdInput = new TextField();
    Button btnEditProduct = new Button("MODIFY");
    Button btnBack = new Button("BACK");
    Button btnDelete = new Button("DELETE");

    //Order To deal with
    Order order;

    //View to deal with
    MainView view;

    //Controller to deal with
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

    //Method to populate the Hboxes and Vboxes
    //TODO Needs styling and organizing but it works under the weird circumstances speficied above
    public EditView(){
        super();
        // code to create components and do all the layout
        VBox pane = new VBox();

        //HBox Options
        HBox rowOptions = new HBox();

        rowOptions.setSpacing(20);
        rowOptions.getChildren().addAll(btnEditProduct, btnDelete, btnBack);

        //Not so sure what the hell is this but If it doesn't have this it doesn't work
        pane.getChildren().addAll(lblTitle, itemEditDisplay, fldIdInput, rowOptions);

        //Disabled Display
        itemEditDisplay.setDisable(true);
        itemEditDisplay.setText("Insert ID Bellow");
        itemEditDisplay.setMinHeight(30);
//        itemEditDisplay.prefHeightProperty().bind(itemEditDisplay.prefWidthProperty());

        Scene scene = new Scene(pane, 200, 200);
        this.setScene(scene);
        this.setTitle("Title of Second Window");
        // use initModality if you want this Stage to block the app
        this.initModality(Modality.WINDOW_MODAL);
        btnBack.setOnAction(e->{
            this.close();
        });

        btnDelete.setOnAction(e -> {

           try {
              int idToDelete = Integer.parseInt(fldIdInput.getText());
              order.getItems().remove(idToDelete);
              view.getOrderItemsDisplay().setText(order.toString());

           } catch (Exception ex){
              ex.printStackTrace();
           }
       });

        /***
         * Modify Section
         */
        //HBox and Vboxes for Modifying product
        //Type Item and respective Drop down list
        Label lblItemType = new Label("Item Type");
        String[] item_type = {"Drink", "Food"};
        ComboBox cmbItemType = new ComboBox<>(FXCollections.observableArrayList(item_type));

        //Item name with it's text field
        Label lblItemName = new Label("Item Name");
        TextField fldItemName = new TextField();

        //Ingredients label and it's text field
        Label lblIngredients = new Label("Ingredients");
        TextField fldIngredients = new TextField();

        //Size label and it's Drop down list
        Label lblSize = new Label("Size");
        String[] size = {"Small", "Medium", "Large"};
        ComboBox cmbSize = new ComboBox<>(FXCollections.observableArrayList(size));

        //Add Button
        Button btnConfirm = new Button("CONFIRM");
        /**
         * Modify Section Ends
         */

        //BottomPane divided into left Side and Right side
        VBox leftSide = new VBox();

        //Left side Content
        HBox rowItemType = new HBox(lblItemType, cmbItemType);
        rowItemType.setSpacing(10);
        cmbItemType.getSelectionModel().select(-1);

        HBox rowItemName = new HBox(lblItemName, fldItemName);
        rowItemName.setSpacing(2);

        //Ingredients row show if it's food not drink
        HBox rowIngredients = new HBox(lblIngredients, fldIngredients);
        rowIngredients.setSpacing(2);

        HBox rowSize = new HBox(lblSize, cmbSize);
        cmbSize.getSelectionModel().selectFirst();
        rowSize.setSpacing(40);

        HBox rowConfirmButton = new HBox(btnConfirm);

        leftSide.getChildren().addAll(rowItemType, rowItemName, rowIngredients, rowSize, rowConfirmButton);


        btnEditProduct.setOnAction(e->{
            pane.getChildren().add(leftSide);
            controller.editView.setHeight(280);
        });

        btnConfirm.setOnAction(e->{
            //Ingredients
            String ingredients = fldIngredients.getText();

            try {

                int idToModify = Integer.parseInt(fldIdInput.getText());
                String newDesc = fldItemName.getText();

                Size newSize;
                switch (view.getCmbSize().getSelectionModel().getSelectedIndex()) {
                    case 0:
                        newSize = Size.SMALL;
                        break;
                    case 1:
                        newSize = Size.MEDIUM;
                        break;
                    case 2:
                        newSize = Size.LARGE;
                        break;
                    default:
                        newSize = Size.SMALL;
                        break;
                }

                if (newDesc.trim() == "" || newDesc == null){
                    view.getAlertInfo().showAndWait();
                } else { //If it's not the case it's updated
                    order.updateOrder(idToModify, newDesc, ingredients, newSize, cmbItemType);
                    view.getOrderItemsDisplay().setText(order.toString());
                }
            } catch (Exception ex) {
                view.getAlertInfo().setContentText("Fields Can't be Empty");
                view.getAlertInfo().showAndWait();
            }

        });
    }


}
