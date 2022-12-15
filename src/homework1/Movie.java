package homework1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Movie implements Serializable {
    private String title;
    private String genre;
    private Calendar releaseDate;
    private String country;
    private String[] cast;
    private boolean marker;

    public Movie (String title, String genre, Calendar releaseDate, String country, String[] cast) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.country = country;
        this.cast = cast;
    }
    public Movie(){
        this.marker = true;
    }

    public String getTitle() {
        return title;
    }

    public String showInfo(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return "Title: " + title + "\n" +
                "Genre: " + genre + "\n" +
                "Release Date: " + format.format(releaseDate.getTime()) + "\n" +
                "Country: " + country + "\n" +
                "Top cast: " + String.join("; ", cast) + "\n";
    }

    public boolean isMarker() {
        return marker;
    }

    @Override
    public String toString() {
        return this.showInfo();
    }
}
