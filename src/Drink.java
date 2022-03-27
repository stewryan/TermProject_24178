public class Drink extends MenuItem{

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
        return String.format("ID: %d.\nDescription: %s \nContains %d calories in the %s size at the price of $%5.2f.", 
        this.getID(), this.getDescription(), this.getCalories(), this.getSize(), this.getPrice());
    }

}
