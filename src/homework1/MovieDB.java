package homework1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class MovieDB {
    private Set<Movie> movies;

    public MovieDB(List<Movie> movieList) {
        movies = new HashSet<>(movieList);
    }
    public Set<Movie> getAll(){
        return movies;
    }
    public Set<Movie> getByTitle(String title){
        Pattern pattern = Pattern.compile(title);

        Set<Movie> result = new HashSet<>();
        for (Movie movie:movies)
            if (movie.getTitle().equals(title)) result.add(movie);
        return result;
    }
}
