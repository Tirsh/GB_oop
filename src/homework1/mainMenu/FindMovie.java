package homework1.mainMenu;

import homework1.Movie;
import homework1.MovieDB;

import java.util.Scanner;
import java.util.Set;

public class FindMovie implements Option{
    @Override
    public void executeAction(MovieDB movieDB) {
        Set<Movie> movies;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название или его часть для поиска:");
        movies = movieDB.getByTitle(scanner.nextLine());
        System.out.println(MovieDB.showResult(movies));
    }
}
