package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public class DigitalVideoDisc extends Disc implements Playable {
    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public String toString() {
        return "DVD (ID = " + id + ") - " + this.title + "\t - \t" + this.category
                + "\t - \t" + this.director + "\t - \t" + this.length + "\t : \t $" + this.cost;
    }

    @Override
    public void play() {
        if(this.length <= 0 ) {
            System.out.println("This DVD cannot be played");
        }
        else {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
    }

    public String getDetails() {
        return "DVD (ID = " + id + ") - " + this.title + "\t - \t" + this.category
                + "\t - \t" + this.director + "\t - \t" + this.length + "\t : \t $" + this.cost;
    }
}
