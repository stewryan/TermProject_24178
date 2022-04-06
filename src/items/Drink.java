package items;

public class Drink extends MenuItem implements MultiSize {

    private Size drinkSize;

    /**
     * 
     * @param id
     * @param desc
     * @param price
     * @param discount
     * @param size
     */
    public Drink(int id, String desc, double price, double discount, Size size, int calories) {
        super(id, desc, price, discount, calories);
        this.drinkSize = size;
    }

    public void setSize(Size size) {
        this.drinkSize = size;
    }
    public Size getSize() {
        return this.drinkSize;
    }

    @Override
    public String toString() {
        return String.format("%s | Contains %d calories in the %s size.", 
        this.getDescription(), this.getCalories(), this.getSize());
    }

}
