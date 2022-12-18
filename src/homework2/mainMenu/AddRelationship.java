package homework2.mainMenu;

import homework2.Controller;

public class AddRelationship implements Option{
    @Override
    public void executeAction(Controller controller) {
        controller.addRelationship();
    }
}
