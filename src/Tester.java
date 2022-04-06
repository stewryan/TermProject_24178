public class Tester {

    public static void main(String[] args) {

        Order order = new Order();

        Drink smallPepsi = new Drink(45, "Pepsi (S)", 2.49, 0.98, Size.SMALL, 85);
        Drink mediumPepsi = new Drink(46, "Pepsi (M)", 4.49, 0.94, Size.MEDIUM, 140);
        Drink largePepsi = new Drink(47, "Pepsi (L)", 7.49, 0.92, Size.LARGE, 275);

        order.add(smallPepsi);
        order.add(mediumPepsi);
        order.add(largePepsi);

        System.out.println(order.completeOrder());

        

    }
    
}
