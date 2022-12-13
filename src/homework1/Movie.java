package homework1;

import java.util.Date;
import java.util.List;

public class Movie {
    private String title;
    private String genre;
    private Date releaseDate;
    private String country;
    private List<String> cast;

    public Movie(String title, String genre, Date releaseDate, String country, List<String> cast) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.country = country;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public void showInfo(){
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Country: " + country);
        System.out.println("Top cast: " + String.join(" ;", cast));
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                ", country='" + country + '\'' +
                ", cast=" + cast +
                '}';
    }
}
