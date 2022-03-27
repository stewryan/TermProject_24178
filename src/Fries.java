public class Fries extends FoodItem {
    
    private Size size;

    public Fries() {
        super(9, "French Fries", 2.99, 0.02, new String[]{"Potato", "Salt"}, 0);
        this.setSize(Size.SMALL);
    }

    public void setSize(Size size) {
        this.size = size;
    }
    public Size getSize() {
        return this.size;
    }

}
