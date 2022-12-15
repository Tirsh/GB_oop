package homework1.mainMenu;

import homework1.MovieDB;

public class CleanBase implements Option{
    @Override
    public void executeAction(MovieDB movieDB) {
        movieDB.cleanAll();
        System.out.println("База очищена!");
    }
}
