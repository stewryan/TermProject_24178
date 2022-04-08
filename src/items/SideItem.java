package items;

/**
 * A class that repsents an item on the side of a meal/order, such as French Fries
 * 
 * @author Ryan Stewart
 */
public class SideItem extends FoodItem implements MultiSize {
    
    private Size size;

    public SideItem(int id, String desc, double discount, Size size) {
        super(9, "French items.Fries", 0.02, new String[]{});
        this.size = size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    public Size getSize() {
        return this.size;
    }

}
