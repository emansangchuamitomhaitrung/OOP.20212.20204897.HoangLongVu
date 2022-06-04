package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        // TODO Auto-generated constructor stub
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if(this.authors.contains(authorName)) {
            System.out.println("Author already existed.");
        }
        else {
            this.authors.add(authorName);
            System.out.println("Author " + authorName + " added successfully.");
        }
    }

    public void removeAuthor(String authorName) {
        if(!this.authors.contains(authorName)) {
            System.out.println("This author does not exist in the list. Please try again.");
        }
        else {
            this.authors.remove(authorName);
            System.out.println("Author " + authorName + " removed from the list.");
        }
    }

}
