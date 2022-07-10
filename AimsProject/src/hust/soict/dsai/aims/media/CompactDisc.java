package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    public ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title, String artist) {
        super(title);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, int length, String artist, ArrayList<Track> tracks) {
        super(title, category, cost, length);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, float cost, int length, String artist) {
        super(title, category, cost, length);
        this.artist = artist;
    }

    public CompactDisc(String title, String director, String category, float cost, String artist) {
        super(title, director, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String director, String category, int length, float cost, String artist) {
        super(title, director, category, length, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
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

    public void removeTrack(Track track) throws NoSuchElementException {
        if(!tracks.contains(track)) {
            throw new NoSuchElementException("The track does not exist. Please try again.");
        }
        else {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed from the list.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for(Track track : this.tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException{
        if(this.getLength() <= 0) {
            throw new PlayerException("The CD cannot be played");
        }
        else {
            System.out.println("Playing tracks by: " + this.artist);
            System.out.println("Total length: " + this.getLength());
//            for (Track track : tracks) {
//                try {
//                    track.play();
//                } catch (PlayerException e) {
//                    e.printStackTrace();
//                }
//            }
        java.util.Iterator iter = tracks.iterator();
        Track nextTrack;
        while(iter.hasNext()) {
            nextTrack = (Track) iter.next();
            try {
                nextTrack.play();
            } catch(PlayerException e) {
                throw e;
            }
        }
        }
    }

    public String toString() {
        StringBuffer trackInfo = new StringBuffer();
        for(Track track : tracks) {
            trackInfo.append(track.toString());
        }
        return
                "CD: " + this.title +
                        "\nCategory: " + this.category +
                        "\nArtist: " + this.artist +
                        "\nDirector: " + this.director +
                        "\nCD length: " + this.getLength() +
                        "\nCost: " + this.cost +
                        "\nTracks: " + trackInfo;
    }

}
