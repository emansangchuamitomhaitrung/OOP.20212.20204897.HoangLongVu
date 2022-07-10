package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private final String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public Track(String title) {
        this.title = title;
    }

    @Override
    public void play() throws PlayerException {
        if(this.length <= 0) {
            throw new PlayerException("The track cannot be played");
        }
        else {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
    }

    public String toString() {
        return this.title + "\t - \t" + this.length;
    }

    public boolean equals(Object o) {
        if(o instanceof Track) {
            Track that = (Track) o;
            return ((this.getTitle() == that.getTitle()) && (this.getLength() == that.getLength()));
        }
        else return false;
    }
    
}
