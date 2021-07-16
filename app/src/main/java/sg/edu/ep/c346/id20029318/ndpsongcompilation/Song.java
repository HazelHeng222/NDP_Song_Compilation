package sg.edu.ep.c346.id20029318.ndpsongcompilation;

import java.io.Serializable;

public class Song implements Serializable {

    private 	int id;
    private 	String title;
    private     String singers;
    private     int year;
    private     int stars;

    public Song( int id, String title, String singers, int year, int stars  ) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public Song( String title, String singers, int year, int stars  ) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }


    @Override
    public String toString() { return "ID:" + id + "\nTitle: " + title + "\nSingers: " + singers + "\nYear: " + year + "\n" + stars;  }
}
