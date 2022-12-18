package homework2;

import homework2.mainMenu.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    Controller controller;

    public UserInterface() {
        controller = new Controller();
    }

    public void startMainMenu(){
        Map<Integer, Option> mainMenu = new HashMap<>();
        mainMenu.put(1, new CreateNewTree());
        mainMenu.put(2, new LoadTree());
        mainMenu.put(3, new ResearchMenu());
        mainMenu.put(4, new CloseAndSave());
        mainMenu.put(5, new Close());
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        while(result != 5){
            System.out.println("1. Создать новое генеалогическое древо");
            System.out.println("2. Загрузить генеалогическое древо из файла");
            System.out.println("3. Исследование древа");
            System.out.println("4. Сохранить изменения");
            System.out.println("5. Выйти");
            if (scanner.hasNextInt()){
                if (mainMenu.containsKey(result = scanner.nextInt())) {
                    mainMenu.get(result).executeAction(controller);
                    if (result == 3) researchMenu(controller);
                }
            }else scanner.next();
        }
        scanner.close();
    }
    public void researchMenu(Controller controller) {
        Map<Integer, Option> researchMap = new HashMap<>();
        researchMap.put(1, new ShowFullTree());
        researchMap.put(2, new AddRelationship());
        researchMap.put(3, new FindInTree());
        researchMap.put(4, new Close());
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        while (result != 4) {
            System.out.println("1. Показать древо");
            System.out.println("2. Добавить связь");
            System.out.println("3. Поиск по древу");
            System.out.println("4. Назад");
            if (scanner.hasNextInt()) {
                if (researchMap.containsKey(result = scanner.nextInt())) {
                    researchMap.get(result).executeAction(controller);
                    if (result == 3) researchMenu(controller);
                }
            } else scanner.next();
        }
    }
}
