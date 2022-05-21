package aims;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Disc added sucessfully. Title: " + disc.getTitle());
        }
        else {
            System.out.println("The cart is almost full.");
        }
        System.out.println("Currently: " + qtyOrdered + " items in cart.");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(this.qtyOrdered == 0) {
            System.out.println("Error. The cart is empty");
        }
        else {
            int removeCount = 0;
            for(int i=0; i < this.qtyOrdered; i++) {
                if(disc.getTitle() == itemsOrdered[i].getTitle()) {
                    itemsOrdered[i] = null;
                    qtyOrdered--;
                    removeCount++;
                }
            }
            System.out.println("Removed " + removeCount + " disc(s) successfully.");
        }
        System.out.println("Currently: " + qtyOrdered + " items in cart.");
    }

    public float totalCost() {
        float cost = 0.0F;
        for(int i=0; i < qtyOrdered; i++) {
            cost += itemsOrdered[i].getCost();
        }

        return cost;
    }

    // OVERLOADING METHODS
    // Add a list of DVDs to the current cart
//    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
//        for (DigitalVideoDisc disc : dvdList) {
//            if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
//                itemsOrdered[qtyOrdered] = disc;
//                qtyOrdered++;
//                System.out.println("Disc added successfully. Title: " + disc.getTitle());
//            }
//            else {
//                System.out.println("The cart is almost full.");
//            }
//        }
//        System.out.println("Currently: " + qtyOrdered + " items in cart.");
//
//    }

    // Add an arbitrary number of arguments
    public void addDigitalVideoDisc(DigitalVideoDisc... discs) {
        for(DigitalVideoDisc dvd:discs) {
            if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = dvd;
                qtyOrdered++;
                System.out.println("Disc added successfully. Title: " + dvd.getTitle());
            }
            else {
                System.out.println("The cart is almost full.");
            }
        }
        System.out.println("Currently: " + qtyOrdered + " items in cart.");
    }

    // Add two DVDs at the same time
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("Disc added sucessfully. Title: " + dvd1.getTitle());
        }
        else {
            System.out.println("The cart is almost full.");
        }

        if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("Disc added successfully. Title: " + dvd2.getTitle());
        }
        else {
            System.out.println("The cart is almost full.");
        }
        System.out.println("Currently: " + qtyOrdered + " items in cart.");

    }
    

}
