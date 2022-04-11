import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    TextArea itemEditDisplay = new TextArea();
    TextField fldIdInput = new TextField();
    Button btnEditProduct = new Button("MODIFY");
    Button btnDeleteProduct = new Button("DELETE");
    Button btnBack = new Button("BACK");
    private javafx.scene.control.Button btnDelete = new Button("DELETE");

    //Method to populate the Hboxes and Vboxes
    //TODO Needs styling and organizing but it works under the weird circumstances speficied above
    public EditView(){
        super();
        // code to create components and do all the layout
        VBox pane = new VBox();



        //Not so sure what the hell is this but If it doesn't have this it doesn't work
        pane.getChildren().addAll(lblTitle, itemEditDisplay, fldIdInput, btnEditProduct, btnBack);

        //Disabled Display
        itemEditDisplay.setDisable(true);
        itemEditDisplay.setText("Test");
        itemEditDisplay.setPrefHeight(200);
        itemEditDisplay.prefHeightProperty().bind(itemEditDisplay.prefWidthProperty());

        Scene scene = new Scene(pane, 200, 200);
        this.setScene(scene);
        this.setTitle("Title of Second Window");
        // use initModality if you want this Stage to block the app
        this.initModality(Modality.WINDOW_MODAL);
        btnBack.setOnAction(e->{
            this.close();
        });
    }


}
