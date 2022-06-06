package hust.soict.dsai.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String director, String category, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String director, String category, int length, float cost) {
        super(title, category, cost);
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
