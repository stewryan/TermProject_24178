import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    javafx.scene.control.Label lblTitle = new javafx.scene.control.Label("EDIT A PRODUCT");
    javafx.scene.control.TextArea itemEditDisplay = new javafx.scene.control.TextArea();
    javafx.scene.control.TextField fldIdInput = new javafx.scene.control.TextField();
    javafx.scene.control.Button btnEditProduct = new javafx.scene.control.Button("EDIT PRODUCT WITH THIS ID");
    javafx.scene.control.Button btnBack = new javafx.scene.control.Button("BACK");

    //Method to populate the Hboxes and Vboxes
    //TODO Needs styling and organizing but it works under the weird circumstances speficied above
    public EditView(){
        super();
        // code to create components and do all the layout
        VBox pane = new VBox();

        //Not so sure what the hell is this but If it doesn't have this it doesn't work
        pane.getChildren().addAll(lblTitle, itemEditDisplay, fldIdInput, btnEditProduct, btnBack);
        Scene scene = new Scene(pane);
        this.setScene(scene);
        this.setTitle("Title of Second Window");
        // use initModality if you want this Stage to block the app
        this.initModality(Modality.WINDOW_MODAL);
        btnBack.setOnAction(e->{
            this.close();
        });
    }


}
