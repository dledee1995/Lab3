package java2.devaunteledee.com.lab3;

/**
 * test
 */
public class Funny {
    String name;
    String author;
    String numberOfComments;
    String Funnyimage;

    public Funny(String name, String author, String numberOfComments, String funnyimage) {
        this.name = name;
        this.author = author;
        this.numberOfComments = numberOfComments;
        Funnyimage = funnyimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(String numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public String getFunnyimage() {
        return Funnyimage;
    }

    public void setFunnyimage(String funnyimage) {
        Funnyimage = funnyimage;
    }
}
