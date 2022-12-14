package homework1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Movie implements Serializable {
    private String title;
    private String genre;
    private Calendar releaseDate;
    private String country;
    private String[] cast;

    public Movie (String title, String genre, Calendar releaseDate, String country, String[] cast) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.country = country;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public String showInfo(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Title: " + title + "\n");
        stringBuilder.append("Genre: " + genre + "\n");
        stringBuilder.append("Release Date: " + format.format(releaseDate.getTime()) + "\n");
        stringBuilder.append("Country: " + country + "\n");
        stringBuilder.append("Top cast: " + String.join("; ", cast) + "\n");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.showInfo();
    }
}
