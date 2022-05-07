package aims;

import com.sun.webkit.dom.DocumentImpl;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(this.qtyOrdered < 20) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Disc added sucessfully.");
        }
        else {
            System.out.println("The cart is almost full.");
        }
    }


    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(this.qtyOrdered == 0) {
            System.out.println("Error. The cart is empty");
        }
        else {
            // FUNCTION TO REMOVE THE DISC
            System.out.println("Disc removed successfully. There are " + this.qtyOrdered + " items left in the cart.");
        }
    }

    public float totalCost() {
        float cost = 0.0F;
        for(int i=0; i < qtyOrdered; i++) {
            cost += itemsOrdered[i].getCost();
        }

        return cost;
    }

    // overloading methods
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {

    }

    public void addDigitalVideoDisc(DigitalVideoDisc... dvd) {

    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {

    }

}
