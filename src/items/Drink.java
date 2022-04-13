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
     * @param id
     * @param desc
     * @param discount
     * @param size
     */
    public Drink(int id, String desc, double discount, Size size) {
        super(id, desc, discount);
        this.drinkSize = size;
        this.price = PriceCalculator.calculateDrinkprice(this);
    }

    public void setSize(Size size) {
        this.drinkSize = size;
    }
    public Size getSize() {
        return this.drinkSize;
    }

    public int getCalories() {
        return this.calories;
    }
    // generate the amount of calories for a drink
    public void setCalories() {
        
    }

    @Override
    public String toString() {
        return String.format("%s | Contains %d calories in the %s size.", 
        this.getDescription(), this.getCalories(), this.getSize());
    }

}
