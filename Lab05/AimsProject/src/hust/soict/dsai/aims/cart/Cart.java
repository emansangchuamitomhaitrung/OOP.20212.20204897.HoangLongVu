package hust.soict.dsai.aims.cart;


import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public float totalCost() {
        float cost = 0.0F;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            cost += this.itemsOrdered.get(i).getCost();
        }
        return cost;
    }

    public void addMedia(Media... media) {
        for(Media medium : media) {
            if(itemsOrdered.size() > MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full. Please try again");
            }
            else {
                itemsOrdered.add(medium);
                System.out.println("Media added successfully. Current cart: " + itemsOrdered.size() + " items.");
            }
        }

    }

    public void removeMedia(Media medium) {
        if(itemsOrdered.size() <= 0) {
            System.out.println("The current cart is empty.");
        }
        else {
            itemsOrdered.remove(medium);

            // TODO 'not found' case?
            System.out.println("Media removed successfully.");
        }
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


    public void searchById(int id) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                found = true;
                index = i;
            }
        }
        if (found) {
            System.out.println("Item found. " + itemsOrdered.get(index).toString());
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

    public DigitalVideoDisc[] sortByTitleCost(DigitalVideoDisc[] dvdList) {
        // sort by title
        Comparator<DigitalVideoDisc> nameSort = Comparator.comparing(DigitalVideoDisc::getTitle);

        // sort by cost
        Comparator<DigitalVideoDisc> costSort = Comparator.comparing(DigitalVideoDisc::getCost, Comparator.reverseOrder());

        // combining multiple sort comparators
        Comparator<DigitalVideoDisc> multipleFieldComparator = nameSort
                .thenComparing(costSort);

        // sorting
        Arrays.sort(dvdList, multipleFieldComparator);
        return dvdList;
    }

    public DigitalVideoDisc[] sortByCostTitle(DigitalVideoDisc[] dvdList) {
        // sort by title
        Comparator<DigitalVideoDisc> nameSort = Comparator.comparing(DigitalVideoDisc::getTitle);

        // sort by cost
        Comparator<DigitalVideoDisc> costSort = Comparator.comparing(DigitalVideoDisc::getCost, Comparator.reverseOrder());

        // combining multiple sort comparators
        Comparator<DigitalVideoDisc> multipleFieldComparator = costSort
                .thenComparing(nameSort);

        // sorting
        Arrays.sort(dvdList, multipleFieldComparator);
        return dvdList;
    }


    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        DigitalVideoDisc[] tmp = new DigitalVideoDisc[this.itemsOrdered.size()];
        System.arraycopy(this.itemsOrdered, 0, tmp, 0, this.itemsOrdered.size());
        sortByTitleCostLength(tmp);

        for(int i = 0; i < tmp.length; i++) {
            System.out.println(i + 1 + ". " + tmp[i].toString());
        }
        DecimalFormat numberFormat = new DecimalFormat("#.00"); // format two 2 numbers after decimal point
        System.out.println("Total cost: $" + numberFormat.format(this.totalCost()));

    }

    public void searchByTitle(String title) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            if (this.itemsOrdered.get(i).equals(title.toLowerCase())) { //TODO check this later
                found = true;
                index = i;
            }
        }
        if (found) {
            System.out.println("Item found. " + itemsOrdered.get(index).toString());
        }
        else {
            System.out.println("Item not found. Please try another ID.");
        }
    }

    public void filterById(int id) {
        boolean found = false;
        DigitalVideoDisc[] tmp = new DigitalVideoDisc[this.itemsOrdered.size()];
        System.arraycopy(this.itemsOrdered, 0, tmp, 0, this.itemsOrdered.size());

        System.out.println("Search Result:");
        for(DigitalVideoDisc disc : tmp) {
            if(disc.getId() == id) {
                System.out.println(disc);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Items not found. Please enter another ID.");
        }
    }

    public void filterByTitle(String title) {
        boolean found = false;
        DigitalVideoDisc[] tmp = new DigitalVideoDisc[this.itemsOrdered.size()];
        System.arraycopy(this.itemsOrdered, 0, tmp, 0, this.itemsOrdered.size());

        System.out.println("Search Result:");
        for(DigitalVideoDisc disc : tmp) {
            if(disc.getTitle().equalsIgnoreCase(title)) {
                System.out.println(disc);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Items not found. Please enter another title (case-insensitive).");
        }
    }
}


