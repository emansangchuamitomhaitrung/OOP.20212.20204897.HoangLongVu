package hust.soict.dsai.aims.media;

import java.time.LocalDate;

import static java.time.LocalDate.*;


public class DigitalVideoDisc extends Disc implements Playable {
    private LocalDate dateAdded;
    private static int nbDigitalVideoDiscs = 0;

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public DigitalVideoDisc(String title, String director, String category, float cost) {
        super(title, category, director, cost);
        this.id = nbDigitalVideoDiscs;
        this.dateAdded = now();
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        this.dateAdded = now();
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title) {
        super(title);
        this.dateAdded = now();
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String director, String category, int length, float cost) {
        super(title, category, director, length, cost);
        this.dateAdded = now();
        this.id = nbDigitalVideoDiscs;
        nbDigitalVideoDiscs++;
    }



    public String toString() {
        return "DVD (ID = " + id + ") - " + this.title + "\t - \t" + this.category
                + "\t - \t" + this.director + "\t - \t" + this.length + "\t : \t $" + this.cost;
    }

    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
