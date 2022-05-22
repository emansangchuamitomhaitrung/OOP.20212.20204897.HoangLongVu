package aims;

import com.sun.corba.se.impl.transport.DefaultIORToSocketInfoImpl;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add to cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin", "Animation", 30f); // test sort by title-cost
        cart.addDigitalVideoDisc(dvd4);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 120, 19.95f); // test sort by title-cost-length
        cart.addDigitalVideoDisc(dvd5);
        // Test print method
        cart.print();
        // Test search method
        cart.searchDVD(2); // returns Aladin DVD
    }
}
