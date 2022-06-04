package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;

public class CompactDisc extends Disc {
    private String artist;
    public ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title, String category, float cost, LocalDate dateAdded, int id, int length, String director) {
        super(title, category, cost, dateAdded, id, length, director);
    }

    public void addTrack(Track track) {
        if(tracks.contains(track)) {
            System.out.println("The track is already in the list.");
        }
        else {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added successfully.");
        }
    }

    public void removeTrack(Track track) {
        if(!tracks.contains(track)) {
            System.out.println("The track does not exist. Please try again.");
        }
        else {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed from the list.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for(Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

}
