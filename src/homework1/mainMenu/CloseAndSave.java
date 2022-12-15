package homework1.mainMenu;

import homework1.MovieDB;

public class CloseAndSave implements Option{
    @Override
    public void executeAction(MovieDB movieDB) {
        movieDB.saveData();
    }
}
