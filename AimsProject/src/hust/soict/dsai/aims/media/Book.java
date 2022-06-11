package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        for(String author : this.authors) {
            if(author.equalsIgnoreCase(authorName.toLowerCase())) {
                System.out.println("This author is already in the list.");
            }
        }
        this.authors.add(authorName);
        System.out.println("Author " + authorName + " added sucessfully.");
    }

    public void removeAuthor(String authorName) {
        for(String author : this.authors) {
            if(!author.equalsIgnoreCase(authorName.toLowerCase())) {
                System.out.println("Author does not exists. Please try another name.");
            }
        }
        this.authors.remove(authorName);
        System.out.println("Author " + authorName + " removed from the list.");
    }

    public String getDetails() {
        StringBuffer authorList = new StringBuffer();
        if(this.authors.size() >= 1) {
            for(int i = 0; i < this.authors.size()-1; i++) {
                authorList.append(this.authors.get(i));
                authorList.append(", ");
            }
            authorList.append(this.authors.get(this.authors.size() - 1));
        }
        return "Book: (ID = " + this.id + ") - " + this.title + "\t - \t"
                + this.category + "\t - \t$" + this.cost + "\n- Authors: " + authorList;
    }
}
