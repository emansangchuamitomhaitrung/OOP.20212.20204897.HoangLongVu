package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    //private final List<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();



    public void addMedia(DigitalVideoDisc dvd) {
        this.itemsInStore.add(dvd);
        System.out.println("DVD added successfully. Title: " + dvd.getTitle());
    }

    public void removeMedia(DigitalVideoDisc dvd) {
        if(itemsInStore.size() <= 0) {
            System.out.println("The store is empty.");
        }
        this.itemsInStore.remove(dvd);
        System.out.println("DVD removed successfully. Title: " + dvd.getTitle());

    }

    public DigitalVideoDisc searchDVD(String title) {
        for(DigitalVideoDisc dvd : this.itemsInStore) {
            if(dvd.isMatch(title)) {
                return dvd;
            }
        }
        return null;
    }


    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Available items:");
        for(int i = 0; i < this.itemsInStore.size(); i++) {
            System.out.println(i + 1 + ". " + this.itemsInStore.get(i).getTitle());
        }
    }
}
