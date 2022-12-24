package homework3.mainMenu;

import homework3.Controller;

public class CreateNewTree implements Option {
    @Override
    public void executeAction(Controller controller) {
        controller.createNewTree();
        System.out.println("Создано новое дерево!");
    }
}
