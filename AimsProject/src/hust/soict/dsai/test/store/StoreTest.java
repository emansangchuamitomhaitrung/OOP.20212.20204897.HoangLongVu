package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Before sunrise", "Romance", "Richard Linklater", 70, 20f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Before sunset", "Romance", "Richard Linklater", 65, 21.5f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Before midnight", "Romance", "Richard Linklater", 75, 22.3f);
        store.addMedia(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Sadness", "Tragedy", "My Life", 100, 1f);
        store.addMedia(dvd4);

        store.removeMedia(dvd4);

        store.print();
    }



}
