package homework1;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieDB {
    private Set<Movie> movies;
    public MovieDB(String fileLoadFrom){
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileLoadFrom));
        objectInputStream.

    }

    public MovieDB(List<Movie> movieList) {
        movies = new HashSet<>(movieList);
    }
    public Set<Movie> getAll(){
        return movies;
    }
    public Set<Movie> getByTitle(String title){
        Set<Movie> result = new HashSet<>();
        Pattern pattern = Pattern.compile(title.toLowerCase());
        Matcher matcher;
        for (Movie movie:movies) {
            matcher = pattern.matcher(movie.getTitle().toLowerCase());
            if (matcher.find()) result.add(movie);
        }
        return result;
    }
    private String showResult(Set<Movie> movies){
        StringBuilder stringBuilder = new StringBuilder();
        for (Movie movie:movies) stringBuilder.append(movie);
        return stringBuilder.toString();
    }
    public void saveData(String file){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            for (Movie movie : movies) objectOutputStream.writeObject(movie);
            objectOutputStream.close();
        }catch (IOException e){
            System.out.println("Что-то пошло не так");
            e.printStackTrace();
        }

    }
}
