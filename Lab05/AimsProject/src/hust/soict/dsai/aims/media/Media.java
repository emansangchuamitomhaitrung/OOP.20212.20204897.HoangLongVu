package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public abstract class Media {
    protected String title;
    protected String category;
    protected float cost;
    protected LocalDate dateAdded;
    protected int id;
    protected static int nbMedia = 0;

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public Media(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public int getId() {
        return id;
    }

    public static int getNbMedia() {
        return nbMedia;
    }
}
