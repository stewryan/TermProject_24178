package items;

/**
 * A class that repsents an item on the side of a meal/order, such as French Fries
 * Similar to Food Item, however it can be in different SIZES.
 * 
 * @author Ryan Stewart Apr 2022 
 * @author Marcelo Geldres Apr 2022
 */
public class SideItem extends FoodItem implements MultiSize {
    
    private Size size;

    /**
     * 
     * @param desc description/title of the item
     * @param size the size of the item
     */
    public SideItem(String desc, Size size) {
        super(desc, new String[]{});
        this.size = size;
    }

    /**
     * 
     * @param size The size to set to
     */
    public void setSize(Size size) {
        this.size = size;
    }
    /**
     * 
     * @return the size of the current item
     */
    public Size getSize() {
        return this.size;
    }

    @Override
    public String toString() {

        return "(Side) " + this.getSize() + " " + this.getDescription() + " Contains " + this.getCalories() + " calories. " + "\n\t Ingredients: " + this.getIngredients();

    }

}
