package hust.soict.dsai.test;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class AimsTest {
    public static void main(String[] args) {
        /* These are the test cases for previous Labs (02 and 03) */

        // Create a new cart
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addMedia(dvd3);

        // Print total cost of the items in the cart
        System.out.println("Total cost is: " + anOrder.totalCost());

        // Remove items
        //anOrder.removeMedia("Aladin");
        //anOrder.removeMedia(new DigitalVideoDisc("Doctor Strange"));  // item not found

        // Testing overloading methods
        /*
        DigitalVideoDisc[] dvdList = {new DigitalVideoDisc("Star Wars 2"), new DigitalVideoDisc("Bond")};
        anOrder.addMedia(dvdList);  // method with input as an array

        anOrder.addMedia(new DigitalVideoDisc("Before sunrise"),
                new DigitalVideoDisc("Before sunset"),
                new DigitalVideoDisc("Before midnight")); // method with arbitrary number of arguments

        anOrder.addMedia(new DigitalVideoDisc("Bond 01"), new DigitalVideoDisc("Bond 02")); // method with two parameters


         */
    }
}
