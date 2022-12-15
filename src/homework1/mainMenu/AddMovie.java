package homework1.mainMenu;

import homework1.Movie;
import homework1.MovieDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class AddMovie implements Option{
    public Movie getMovieInfo(){
        String title;
        String genre;
        Calendar releaseDate = Calendar.getInstance();
        String country;
        String[] cast;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название фильма:");
        title = scanner.nextLine();
        System.out.println("Введите жанр фильма:");
        genre = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while (true)
            try {
                System.out.println("Введите дату выхода (yyyy-mm-dd):");
                releaseDate.setTime(sdf.parse(scanner.nextLine()));
                break;
            } catch (ParseException e) {
                System.out.println("Некоректный ввод или неверный формат времени");
            }
        System.out.println("Введите страну:");
        country = scanner.nextLine();
        System.out.println("Введите актеров, через ',':");
        cast = Arrays.stream(scanner.nextLine().split(",")).map(String::strip).toArray(String[]::new);
        return new Movie(title, genre, releaseDate, country, cast);
    }
    @Override
    public void executeAction(MovieDB movieDB) {
        movieDB.addMovie(getMovieInfo());
    }
}
