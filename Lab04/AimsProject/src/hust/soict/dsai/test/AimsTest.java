package hust.soict.dsai.test;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class AimsTest {
    public static void main(String[] args) {
        /* These are the test cases for previous Labs (02 and 03) */

        // Create a new cart
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // Print total cost of the items in the cart
        System.out.println("Total cost is: " + anOrder.totalCost());

        // Remove items
        anOrder.removeDigitalVideoDisc(new DigitalVideoDisc("Aladin"));
        anOrder.removeDigitalVideoDisc(new DigitalVideoDisc("Doctor Strange"));  // item not found

        // Testing overloading methods
        DigitalVideoDisc[] dvdList = {new DigitalVideoDisc("Star Wars 2"), new DigitalVideoDisc("Bond")};
        anOrder.addDigitalVideoDisc(dvdList);  // method with input as an array

        anOrder.addDigitalVideoDisc(new DigitalVideoDisc("Before sunrise"),
                new DigitalVideoDisc("Before sunset"),
                new DigitalVideoDisc("Before midnight")); // method with arbitrary number of arguments

        anOrder.addDigitalVideoDisc(new DigitalVideoDisc("Bond 01"), new DigitalVideoDisc("Bond 02")); // method with two parameters

    }
}
