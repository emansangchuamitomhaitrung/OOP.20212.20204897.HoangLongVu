package hust.soict.dsai.aims.cart;


import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.Arrays;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }

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
    /*
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("Disc added successfully. Title: " + disc.getTitle());
            }
            else {
                System.out.println("The cart is almost full.");
            }
        }
        System.out.println("Currently: " + qtyOrdered + " items in cart.");

    }
    */

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

    public void sortByCost(DigitalVideoDisc[] dvdList) {
        Arrays.sort(dvdList, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
                return Float.compare(o1.getCost(), o2.getCost());
            }
        });

    }

    public void sortByTitle(DigitalVideoDisc[] dvdList) {
        Arrays.sort(dvdList, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
                return o1.getTitle().compareToIgnoreCase(o2.getTitle());
            }
        });
    }

    public void searchDVD(int id) {
        int ITEM_FOUND = 0;
        int index = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                ITEM_FOUND = 1;
                index = i;
            }
        }
        if (ITEM_FOUND == 1) {
            System.out.println("Item found. Title: " + itemsOrdered[index].getTitle());
        }
        else {
            System.out.println("Item not found. Please try another ID.");
        }
    }

    public DigitalVideoDisc[] sortByTitleCostLength(DigitalVideoDisc[] dvdList) {
        // sort by title
        Comparator<DigitalVideoDisc> nameSort = Comparator.comparing(DigitalVideoDisc::getTitle);

        // sort by cost
        Comparator<DigitalVideoDisc> costSort = Comparator.comparing(DigitalVideoDisc::getCost, Comparator.reverseOrder());

        // sort by length
        Comparator<DigitalVideoDisc> lengthSort = Comparator.comparing(DigitalVideoDisc::getLength, Comparator.reverseOrder());

        // combining multiple sort comparators
        Comparator<DigitalVideoDisc> multipleFieldComparator = nameSort
                .thenComparing(costSort)
                .thenComparing(lengthSort);

        // sorting
        Arrays.sort(dvdList, multipleFieldComparator);
        return dvdList;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        DigitalVideoDisc[] tmp = new DigitalVideoDisc[this.qtyOrdered];
        for(int i = 0; i < this.qtyOrdered; i++) {
            tmp[i] = this.itemsOrdered[i];
        }
        sortByTitleCostLength(tmp);


        for(int i = 0; i < this.qtyOrdered; i++) {
            System.out.println(Integer.toString(i+1) + ". DVD - " + tmp[i].getTitle() + '\t' + tmp[i].getCategory()
            + '\t' + tmp[i].getDirector() + '\t' + tmp[i].getLength() + ": $" + tmp[i].getCost());
        }
        System.out.println("Total cost: $" + this.totalCost());

    }

}
