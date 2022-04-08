import invoice.Order;
import items.Drink;
import items.FoodItem;
// import items.Fries;
import items.Size;

public class MainViewController {

    Order order;

    public MainViewController(MainView view){
        setView(view);
    }

    void setView(MainView view){

        order = new Order();




        view.btnAdd.setOnAction(e->{
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


                Drink drink = new Drink(id, desc, discount, size);
                order.add(drink);
                view.getOrderItemsDisplay().setText(order.completeOrder().toString());
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

                // FoodItem food = new Fries(id, desc, discount);
                // order.add(food);
                FoodItem food = new FoodItem(id, desc, discount, new String[]{"N/A"});
                order.add(food);
                view.getOrderItemsDisplay().setText(order.completeOrder().toString());
            }
        });






    }

}
