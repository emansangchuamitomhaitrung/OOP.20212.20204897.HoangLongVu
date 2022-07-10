package hust.soict.dsai.aims.media;


import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
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
        return "DVD: " + this.title +
                "\nCategory: " + this.category +
                "\nDirector: " + this.title +
                "\nDVD length: " + this.length +
                "\nCost: " + this.cost;
    }
    public void play() throws PlayerException {
        if(this.length <= 0 ) {
            throw new PlayerException("This DVD cannot be played. Length not valid!");
        }
        else {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
    }

}
