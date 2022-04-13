package items;
/**
 * A class that represnts a drink item on the menu, with its own size
 * 
 * @author Ryan Stewart Apr 2022
 */
public class Drink extends MenuItem implements MultiSize {

    private Size drinkSize;

    /**
     * 
     * @param desc
     * @param size
     */
    public Drink(String desc, Size size) {
        super(desc);
        this.drinkSize = size;
        this.price = ValueCalculator.calculateDrinkprice(this);
    }

    @Override
    public double getPrice() {
        return ValueCalculator.calculateDrinkprice(this);
    }

    public void setSize(Size size) {
        this.drinkSize = size;
    }
    public Size getSize() {
        return this.drinkSize;
    }

    /**
     * The text that is displayed in the list of items in an order for a Drink
     */
    @Override
    public String toString() {
        return String.format("%s | Contains %d calories in the %s size.", 
        this.getDescription(), this.getCalories(), this.getSize());
    }

}
