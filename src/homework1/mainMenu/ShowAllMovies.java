package homework1.mainMenu;

import homework1.MovieDB;

public class ShowAllMovies implements Option{
    @Override
    public void executeAction(MovieDB movieDB) {
        System.out.println(MovieDB.showResult(movieDB.getAll()));
    }
}
