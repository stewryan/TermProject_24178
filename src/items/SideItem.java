package items;

/**
 * A class that repsents an item on the side of a meal/order, such as French Fries
 * Similar to Food Item, however it can be in different SIZES.
 * 
 * @author Ryan Stewart
 */
public class SideItem extends FoodItem implements MultiSize {
    
    private Size size;

    public SideItem(String desc, Size size) {
        super(desc, new String[]{});
        this.size = size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    public Size getSize() {
        return this.size;
    }

    @Override
    public String toString() {

        return "(Side) " + this.getSize() + " " + this.getDescription() + "\n\t Ingredients: " + this.getIngredients();

    }

}
