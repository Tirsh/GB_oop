package homework1;

import homework1.mainMenu.*;
import java.util.*;

public class MainUI {
    private final MovieDB movieDB;

    public MainUI(MovieDB movieDB) {
        this.movieDB = movieDB;
    }
    public void startMainMenu(){
        Map<Integer, Option> mainMenu = new HashMap<>();
        mainMenu.put(1, new AddMovie());
        mainMenu.put(2, new FindMovie());
        mainMenu.put(3, new ShowAllMovies());
        mainMenu.put(4, new CleanBase());
        mainMenu.put(5, new CloseAndSave());
        mainMenu.put(6, new Close());
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        while(result != 6){
            System.out.println("1. Добавить фильм в базу");
            System.out.println("2. Поиск по названию или части названия");
            System.out.println("3. Показать все фильмы в базе");
            System.out.println("4. Очистить базу");
            System.out.println("5. Сохранить изменения");
            System.out.println("6. Выйти");

            if (scanner.hasNextInt()){
                if (mainMenu.containsKey(result = scanner.nextInt()))
                    mainMenu.get(result).executeAction(movieDB);
            }else scanner.next();
        }
    }
}
