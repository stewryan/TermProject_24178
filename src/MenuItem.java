public abstract class MenuItem {
    
    private int id;
    private String description;
    private double price;
    private double maxDiscount;
    public boolean isInStock;
    private int calories;

    /**
     * 
     * No-arg constructor for MenuItem. Calls the multiple arg constructor with placeholder values.
     */
    public MenuItem() {
        this(1, "Unnamed Menu Item", 0.0, 0.0, 0);
    }

    /**
     * 
     * @param id the ID of the item on the menu 
     * @param desc the description of what the menu item is
     * @param ingredients the ingredients needed to make the item
     * @param price how much the menu item costs
     * @param discount the max discount the item can have
     */
    public MenuItem(int id, String desc,  double price, double discount, int calories) {
        this.id = id;
        this.description = desc;
        this.price = price;
        this.maxDiscount = discount;
        this.isInStock = true;
        this.calories = calories;
    }

    ///// Getter and setter methods ///////

    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return this.id;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }
    public String getDescription() {
        return this.description;
    }
    

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }

    public void setMaxDiscount(double discount) {
        this.maxDiscount = discount;
    }
    public double getDiscount() {
        return this.maxDiscount;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    public int getCalories() {
        return this.calories;
    }

    @Override
    public String toString() {
        return String.format("%s | Contains %d calories.", 
        this.getDescription(), this.getCalories());
    }

}