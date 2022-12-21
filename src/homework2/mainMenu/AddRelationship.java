package homework2.mainMenu;

import homework2.Controller;
import homework2.Person;
import java.util.Scanner;

public class AddRelationship implements Option{
    Controller controller;
    @Override
    public void executeAction(Controller controller) {
        this.controller = controller;
        controller.clearPersonStack();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавить связь: (1. супружество; 2. Рождение ребенка) ");
        int relationShip = scanner.nextInt();
        switch (relationShip) {
            case 1 -> {
                addOrChoseWhileCreatingRelationship("Супруг:", true, true);
                addOrChoseWhileCreatingRelationship("Супруга:", false, true);
                controller.addRelationship(relationShip);
            }
            case 2 -> {
                addOrChoseWhileCreatingRelationship("Мать:", false, false);
                System.out.println("Ребенок");
                new AddNewMember().executeAction(controller);
                controller.addRelationship(relationShip);
            }
        }
    }
    public Person choseFromExisted(boolean male, boolean single){
        Person[] persons;
        if (single)
            if(male)
                persons = controller.getSingleMen();
            else
                persons = controller.getSingleWomen();
        else
            persons = controller.getWoman();
        int i = 0;
        if (persons.length != 0) {
            for (Person p : persons) {
                System.out.printf("%d. %s\n", 1 + i++, p);
            }
            Scanner scanner = new Scanner(System.in);
            return persons[scanner.nextInt() - 1];
        }
        else
            return null;
    }
    public void addOrChoseWhileCreatingRelationship(String member, boolean male, boolean single){
        Scanner scanner = new Scanner(System.in);
        System.out.println(member);
        System.out.println("1. Создать\n2. Выбрать");
        int answer = scanner.nextInt();
        if (answer == 1)
            new AddNewMember().executeAction(controller);
        else if (answer == 2){
            if (choseFromExisted(male, single) != null)
                controller.addPerson(choseFromExisted(male, single));
            else
                new AddNewMember().executeAction(controller);
        }

    }
}
