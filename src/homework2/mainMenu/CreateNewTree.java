package homework2.mainMenu;

import homework2.Controller;

public class CreateNewTree implements Option {
    @Override
    public void executeAction(Controller controller) {
        controller.createNewTree();
        System.out.println("Создано новое дерево!");
    }
}
