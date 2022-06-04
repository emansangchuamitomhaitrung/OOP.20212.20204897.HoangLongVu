package hust.soict.dsai.aims.media;

import java.time.LocalDate;

import static java.time.LocalDate.*;


public class DigitalVideoDisc extends Disc {
//    private String director;
//    private int length;
    private LocalDate dateAdded;
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, float cost, LocalDate dateAdded, int id, int length, String director) {
        super(title, category, cost, dateAdded, id, length, director);
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
    /*
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs;
        this.dateAdded = now();
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs;
        this.dateAdded = now();
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = nbDigitalVideoDiscs;
        this.dateAdded = now();
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.dateAdded = now();
        this.id = nbDigitalVideoDiscs;
        nbDigitalVideoDiscs++;
    }


     */
    public String toString() {
        return "DVD (ID = " + id + ") - " + this.title + "\t - \t" + this.category
                + "\t - \t" + this.director + "\t - \t" + this.length + "\t : \t $" + this.cost;
    }

    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

}
