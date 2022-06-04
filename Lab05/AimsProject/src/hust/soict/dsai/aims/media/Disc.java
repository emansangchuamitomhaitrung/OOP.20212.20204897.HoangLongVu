package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public class Disc extends Media {
    protected int length;
    protected String director;

    public Disc(String title, String category, float cost, LocalDate dateAdded, int id, int length, String director) {
        super(title, category, cost, dateAdded, id);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
