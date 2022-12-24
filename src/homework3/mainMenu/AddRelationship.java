package homework3.mainMenu;

import homework3.Controller;
import homework3.model.Person;

import java.util.Scanner;

public class AddRelationship implements Option {
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
            while (true) {
                if (scanner.hasNextInt()) {
                    int answer = scanner.nextInt();
                    if (persons.length >= answer && answer > 0)
                        return persons[answer-1];
                    System.out.println("Некорректный ввод!");
                }
                else {
                    System.out.println("Некорректный ввод!");
                    scanner.next();
                }
            }
        }
        else
            return null;
    }
    public void addOrChoseWhileCreatingRelationship(String member, boolean male, boolean single){
        Scanner scanner = new Scanner(System.in);
        System.out.println(member);
        while (true) {
            System.out.println("1. Создать\n2. Выбрать");
            if (scanner.hasNextInt()){
                int answer = scanner.nextInt();
                if (answer == 1) {
                    new AddNewMember().executeAction(controller);
                    break;
                } else if (answer == 2) {
                    Person newPerson = choseFromExisted(male, single);
                    if (newPerson != null)
                        controller.addPerson(newPerson);
                    else
                        new AddNewMember().executeAction(controller);
                    break;
                }
            }
            else
                scanner.next();
        }
    }
}
