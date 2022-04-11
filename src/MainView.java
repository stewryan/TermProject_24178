
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView {

    //View of the class
    private static Parent view;

    //Title
    private Label lblTitle = new Label("Create an Order");

    /***
     * Left side Starts
     */
    //Type Item and respective Drop down list
    private Label lblItemType = new Label("Item Type");
    private String[] item_type = {"Drink", "Food"};
    private ComboBox cmbItemType = new ComboBox<>(FXCollections.observableArrayList(item_type));

    //Item name with it's text field
    private Label lblItemName = new Label("Item Name");
    private TextField fldItemName = new TextField();

    //Ingredients label and it's text field
    private Label lblIngredients = new Label("Ingredients");
    private TextField fldIngredients = new TextField();

    //Size label and it's Drop down list
    private Label lblSize = new Label("Size");
    private String[] size = {"Small", "Medium", "Large"};
    private ComboBox cmbSize = new ComboBox<>(FXCollections.observableArrayList(size));

    //Add Button
    private Button btnAdd = new Button("ADD");

    /***
     * Left side ends
     *
     * Right side Starts
     */

    private TextArea orderItemsDisplay = new TextArea();

//    private Button btnDelete = new Button("DELETE");
    private Button btnEdit = new Button("EDIT");
    private Button btnNext = new Button("Next");
    private Button btnPrev = new Button("Prev");
    private Button btnFirst = new Button("First");
    private Button btnLast = new Button("Last");

    /***
     * RIght side ends
     *
     * Alerts Start
     */

    private Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

    /**
     * Alerts end
     *
     * getters
     * @return
     */
    public Label getLblTitle() {
        return lblTitle;
    }
    public Label getLblItemType() {
        return lblItemType;
    }
    public String[] getItem_type() {
        return item_type;
    }
    public ComboBox getCmbItemType() {
        return cmbItemType;
    }
    public Label getLblItemName() {
        return lblItemName;
    }
    public TextField getFldItemName() {
        return fldItemName;
    }
    public Label getLblIngredients() {
        return lblIngredients;
    }
    public TextField getFldIngredients() {
        return fldIngredients;
    }
    public Label getLblSize() {
        return lblSize;
    }
    public String[] getSize() {
        return size;
    }
    public ComboBox getCmbSize() {
        return cmbSize;
    }
    public Button getBtnAdd() {
        return btnAdd;
    }
    public TextArea getOrderItemsDisplay() {
        return orderItemsDisplay;
    }
//    public Button getBtnDelete() {
//        return btnDelete;
//    }
    public Button getBtnEdit() {
        return btnEdit;
    }
    public Button getBtnNext() {
        return btnNext;
    }
    public Button getBtnFirst() {
        return btnFirst;
    }
    public Button getBtnPrev() {
        return btnPrev;
    }
    public Button getBtnLast() {
        return btnLast;
    }

    public Alert getAlertInfo() {
        return alertInfo;
    }



    public MainView(){
        view = createView();
    }

    public Parent getView(){
        return this.view;
    }

    //HBOXES AND VBOXES CREATED HERE
    private VBox createView() {

        //The "Everything" container
        VBox paneFull = new VBox();

        //2 HBoxes For Top Label and Bottom 2 contents
        HBox topPane = new HBox();
        HBox bottomPane = new HBox();

        //BottomPane divided into left Side and Right side
        VBox rightSide = new VBox();
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

        HBox rowAddButton = new HBox(btnAdd);




        //Right side content
        HBox rowItemDisplay = new HBox(orderItemsDisplay);
        //order items Placeholder
        orderItemsDisplay.setPromptText("ORDER ITEMS HERE");

        HBox rowItemsDisplayOptions = new HBox(btnFirst, btnPrev, btnEdit, btnNext, btnLast);
        rowItemsDisplayOptions.setAlignment(Pos.CENTER);
        rowItemsDisplayOptions.setSpacing(20);


        //Setting all the nodes fully
        leftSide.getChildren().addAll(rowItemType, rowItemName, rowIngredients, rowSize, rowAddButton);
        rightSide.getChildren().addAll(rowItemDisplay, rowItemsDisplayOptions);



        //Setting Bottom pane and Top Pane
        bottomPane.getChildren().addAll(leftSide, rightSide);
        topPane.getChildren().add(lblTitle);//Adding title
        topPane.setAlignment(Pos.CENTER);

        //Set the "everything"
        paneFull.getChildren().addAll(topPane, bottomPane);

        //Alert box for empty fields
        alertInfo.setContentText("None of the fields can be empty");

        return paneFull;

    }



}
