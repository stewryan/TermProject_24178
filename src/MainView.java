
import javafx.collections.FXCollections;
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
    private String[] item_type = {"Food", "Drink"};
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
    Button btnAdd = new Button("ADD");

    /***
     * Left side ends
     *
     * Right side Starts
     */

    private TextArea orderItemsDisplay = new TextArea();

    private Button btnDelete = new Button("DELETE");
    private Button btnFirst = new Button("FIRST");
    private Button btnPrev = new Button("PREV");
    private Button btnNext = new Button("NEXT");
    private Button btnLast = new Button("LAST");

    /***
     * RIght side ends
     */


    /**
     * getters and setters
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
    public Button getBtnDelete() {
        return btnDelete;
    }
    public Button getBtnFirst() {
        return btnFirst;
    }
    public Button getBtnPrev() {
        return btnPrev;
    }
    public Button getBtnNext() {
        return btnNext;
    }
    public Button getBtnLast() {
        return btnLast;
    }



    public MainView(){
        view = createView();
    }

    public Parent getView(){
        return this.view;
    }

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
        HBox rowItemName = new HBox(lblItemName, fldItemName);
        HBox rowIngredients = new HBox(lblIngredients, fldIngredients);
        HBox rowSize = new HBox(lblSize, cmbSize);
        HBox rowAddButton = new HBox(btnAdd);

        //Right side content
        HBox rowItemDisplay = new HBox(orderItemsDisplay);
        //order items Placeholder
        orderItemsDisplay.setPromptText("ORDER ITEMS HERE");

        HBox rowItemsDisplayOptions = new HBox(btnDelete, btnFirst, btnPrev, btnNext, btnLast);
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

        return paneFull;

    }



}
