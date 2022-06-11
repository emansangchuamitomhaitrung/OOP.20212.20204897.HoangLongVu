package hust.soict.dsai.aims.utils;


import hust.soict.dsai.aims.media.DigitalVideoDisc;

import java.util.Arrays;
import java.util.Comparator;

public class DVDUtils {
    public static int compareByCost (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        int HIGHER_COST = Float.compare(dvd1.getCost(), dvd2.getCost());

        if (HIGHER_COST > 0) {
            System.out.println(dvd1.getTitle() + " has higher cost than " + dvd2.getTitle());
        } else if (HIGHER_COST < 0) {
            System.out.println(dvd2.getTitle() + " has higher cost than " + dvd1.getTitle());
        } else {
            System.out.println("Two DVDs have the same cost.");
        }
        return HIGHER_COST;
    }

    public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        int HIGHER_ALPHABET = dvd1.getTitle().compareToIgnoreCase(dvd2.getTitle());

        if (HIGHER_ALPHABET > 0) {
            System.out.println(dvd1.getTitle() + " is lexicographically greater than " + dvd2.getTitle());
        } else if (HIGHER_ALPHABET < 0) {
            System.out.println(dvd2.getTitle() + " is lexicographically greater than " + dvd1.getTitle());
        } else {
            System.out.println("Two DVDs have the same title.");
        }
        return HIGHER_ALPHABET;
    }

    public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList) {
        Arrays.sort(dvdList, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
                return Float.compare(o1.getCost(), o2.getCost());
            }
        });
        return dvdList;
    }

    public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList) {
        Arrays.sort(dvdList, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
                return o1.getTitle().compareToIgnoreCase(o2.getTitle());
            }
        });
        return dvdList;
    }


}
