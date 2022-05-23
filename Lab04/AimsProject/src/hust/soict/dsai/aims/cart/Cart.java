package hust.soict.dsai.aims.cart;


import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Disc added successfully. Title: " + disc.getTitle());
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
            System.out.println("Disc added successfully. Title: " + dvd1.getTitle());
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
/*
    public void sortByCost(DigitalVideoDisc[] dvdList) {
        Arrays.sort(dvdList, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
                return Float.compare(o1.getCost(), o2.getCost());
            }
        });

    }

*/

/*
    public void sortByTitle(DigitalVideoDisc[] dvdList) {
        Arrays.sort(dvdList, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
                return o1.getTitle().compareToIgnoreCase(o2.getTitle());
            }
        });
    }

 */
    public void searchById(int id) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                found = true;
                index = i;
            }
        }
        if (found) {
            System.out.println("Item found. " + itemsOrdered[index].toString());
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

        DigitalVideoDisc[] tmp = new DigitalVideoDisc[this.qtyOrdered];
        System.arraycopy(this.itemsOrdered, 0, tmp, 0, this.qtyOrdered);
        sortByTitleCostLength(tmp);

        for(int i = 0; i < this.qtyOrdered; i++) {
            System.out.println(i + 1 + ". " + tmp[i].toString());
        }
        DecimalFormat numberFormat = new DecimalFormat("#.00"); // format two 2 numbers after decimal point
        System.out.println("Total cost: $" + numberFormat.format(this.totalCost()));

    }

    public void searchByTitle(String title) {
        for(DigitalVideoDisc disc : this.itemsOrdered) {
            if(disc.isMatch(title)) {
                System.out.println("Item found. " + disc);
            }
            else {
                System.out.println("Item not found. Please try another title.");
            }
        }
    }

    public void filterById(int id) {
        boolean found = false;
        System.out.println("Search Result:");
        for(DigitalVideoDisc disc : this.itemsOrdered) {
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
        System.out.println("Search Result:");
        for(DigitalVideoDisc disc : this.itemsOrdered) {
            if(disc.getTitle().equalsIgnoreCase(title)) {
                System.out.println(disc);;
                found = true;
            }
        }
        if(!found) {
            System.out.println("Items not found. Please enter another title (case-insensitive).");
        }
    }
}


