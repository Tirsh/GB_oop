package homework1;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieDB {
    private Set<Movie> movies;
    private String dataFile;
    public MovieDB(String fileLoadFrom){
        this.dataFile = fileLoadFrom;
        movies = new HashSet<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileLoadFrom));
            while (true) {
                Movie movie = (Movie) objectInputStream.readObject();
                if (movie.isMarker())
                    break;
                movies.add(movie);
            }
            objectInputStream.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Что-то пошло не так");
            System.out.println("Файл базы не найден");
        }
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
    public void cleanAll(){
        movies = new HashSet<>();
    }
    public void addMovie(Movie movie){
        movies.add(movie);
    }
    public static String showResult(Set<Movie> movies){
        StringBuilder stringBuilder = new StringBuilder();
        for (Movie movie:movies) {
            stringBuilder.append(movie);
            stringBuilder.append("-----------\n");
        }
        return stringBuilder.toString();
    }
    public void saveData(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(dataFile));
            for (Movie movie : movies) objectOutputStream.writeObject(movie);
            objectOutputStream.writeObject(new Movie());
            objectOutputStream.close();
        }catch (IOException e){
            System.out.println("Что-то пошло не так");
            e.printStackTrace();
        }

    }
}
