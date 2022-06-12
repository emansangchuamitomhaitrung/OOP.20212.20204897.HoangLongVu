package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private String content;
    private List<String> contentTokens;
    private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void processContent() {
        this.contentTokens = Arrays.asList(this.content.split("([.,!?:;'\"-]|\\s)+"));
//        this.contentTokens = Arrays.asList(this.content.split(" "));
        Integer ONE = new Integer(1);
        for(int i=0, n = this.contentTokens.size(); i<n; i++) {
            String key = this.contentTokens.get(i).toLowerCase();
            Integer frequency = this.wordFrequency.get(key);
            if(frequency == null) {
                frequency = ONE;
            }
            else {
                int value = frequency.intValue();
                frequency = new Integer(value+1);
            }
            this.wordFrequency.put(key, frequency);
        }
        Map sortedMap = new TreeMap(this.wordFrequency);
    }

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

    public String toString() {
        this.processContent();
        StringBuffer authorList = new StringBuffer();
        if(this.authors.size() >= 1) {
            for(int i = 0; i < this.authors.size()-1; i++) {
                authorList.append(this.authors.get(i));
                authorList.append(", ");
            }
            authorList.append(this.authors.get(this.authors.size() - 1));
        }
        return "Book: " + this.title +
                        "\nCategory: " + this.category+
                        "\nAuthors:  " + authorList +
                        "\nBook content: " + this.content +
                        "\nContent length: " + this.contentTokens.size() +
                        "\nToken list: " + this.contentTokens +
                        "\nWord frequency: " + this.wordFrequency;

    }

}
