package items;

public class Fries extends FoodItem implements MultiSize{
    
    private Size size;

    public Fries() {
        super(9, "French items.Fries", 0.02, new String[]{"Potato", "Salt"});
        this.setSize(Size.SMALL);
    }

    public void setSize(Size size) {
        this.size = size;
    }
    public Size getSize() {
        return this.size;
    }

}
