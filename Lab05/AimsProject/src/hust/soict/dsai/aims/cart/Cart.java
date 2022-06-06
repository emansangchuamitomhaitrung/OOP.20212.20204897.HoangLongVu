package hust.soict.dsai.aims.cart;


import hust.soict.dsai.aims.media.Media;

import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.Comparator;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private Media luckyItem = null;

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public Media getLuckyItem() {
        return this.luckyItem;
    }

    public float totalCost() {
        float cost = 0.0F;
        for (Media medium : this.itemsOrdered) {
            cost += medium.getCost();
        }
        if(this.luckyItem != null) {
            cost -= this.luckyItem.getCost();
        }
        return cost;
    }

    public void addMedia(Media medium) {
        if(this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full.");
        }
        else {
            this.itemsOrdered.add(medium);
            System.out.println("Media added successfully. Current cart: " + this.itemsOrdered.size() + " items.");
        }
        getALuckyItem();
    }

    public void removeMedia(Media medium) {
        if(itemsOrdered.size() <= 0) {
            System.out.println("The current cart is empty.");
        }
        else {
            if(!itemsOrdered.contains(medium)) {
                System.out.println("Media not found in cart. Please try again.");
            }
            else {
                itemsOrdered.remove(medium);
                System.out.println("Media removed successfully. Current cart: " + this.itemsOrdered.size() + " items.");
            }
        }
        if(this.itemsOrdered.size() <= 5 && (this.luckyItem != null)) { // remove luckyItem if the size reduces to less than 5
            this.itemsOrdered.remove(this.luckyItem);
            this.luckyItem = null;
        }
    }

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
/*
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
 */

    public ArrayList<Media> sortByTitleCost(ArrayList<Media> mediaList) {
        // sort by title
        Comparator<Media> nameSort = Comparator.comparing(Media::getTitle);

        // sort by cost
        Comparator<Media> costSort = Comparator.comparing(Media::getCost, Comparator.reverseOrder());

        // combining multiple sort comparators
        Comparator<Media> multipleFieldComparator = nameSort
                .thenComparing(costSort);

        // sorting
        mediaList.sort(multipleFieldComparator);
        return mediaList;
    }

    public ArrayList<Media> sortByCostTitle(ArrayList<Media> mediaList) {
        // sort by title
        Comparator<Media> nameSort = Comparator.comparing(Media::getTitle);

        // sort by cost
        Comparator<Media> costSort = Comparator.comparing(Media::getCost, Comparator.reverseOrder());

        // combining multiple sort comparators
        Comparator<Media> multipleFieldComparator = costSort
                .thenComparing(nameSort);

        // sorting
        mediaList.sort(multipleFieldComparator);
        return mediaList;
    }


    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        ArrayList<Media> tmp = (ArrayList<Media>) this.itemsOrdered.clone();
        sortByTitleCost(tmp);
        for(int i = 0; i < tmp.size(); i++) {
            System.out.println(i + 1 + ". " + tmp.get(i).toString());
        }
        if (this.luckyItem != null) {
            System.out.println("(** Lucky Item **) " + this.luckyItem.getTitle() + "\t - \t $"  + this.luckyItem.getCost());
        }

        DecimalFormat numberFormat = new DecimalFormat("#.00"); // format two 2 numbers after decimal point
        System.out.println("Total cost: $" + numberFormat.format(this.totalCost()));

    }

    public void searchByTitle(String title) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            if (this.itemsOrdered.get(i).getTitle().equalsIgnoreCase(title.toLowerCase())) {
                found = true;
                index = i;
            }
        }
        if (found) {
            System.out.println("Item found. " + itemsOrdered.get(index).toString());
        }
        else {
            System.out.println("Item not found. Please try another name.");
        }
    }

    public void filterById(int id) {
        boolean found = false;
        ArrayList<Media> tmp = (ArrayList<Media>) this.itemsOrdered.clone();

        System.out.println("Search Result:");
        for(Media medium : tmp) {
            if(medium.getId() == id) {
                System.out.println(medium);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Items not found. Please enter another ID.");
        }
    }

    public void filterByTitle(String title) {
        boolean found = false;
        ArrayList<Media> tmp = (ArrayList<Media>) this.itemsOrdered.clone();

        System.out.println("Search Result:");
        for(Media medium : tmp) {
            if(medium.getTitle().equalsIgnoreCase(title)) {
                System.out.println(medium);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Items not found. Please enter another title (case-insensitive).");
        }
    }

    public Media getALuckyItem() {
        if(this.itemsOrdered.size() >= 5) {
            int rand = (int) ((Math.random() * (this.itemsOrdered.size())));
            this.luckyItem = this.itemsOrdered.get(rand);
            this.itemsOrdered.add(this.luckyItem);
        }
        return this.luckyItem;
    }

}


