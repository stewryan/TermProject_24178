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
        switch(this.getSize()) {
            case SMALL:
                
            break;
        }
    }

    @Override
    public String toString() {
        return String.format("%s | Contains %d calories in the %s size.", 
        this.getDescription(), this.getCalories(), this.getSize());
    }

}
