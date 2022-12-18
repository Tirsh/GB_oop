package homework2.mainMenu;

import homework2.Controller;
import java.util.Scanner;

public class CreateNewTree implements Option {
    @Override
    public void executeAction(Controller controller) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя нового древа:");
        controller.createNewTree(scanner.nextLine());
    }
}
