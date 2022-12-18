package homework2.mainMenu;

import homework2.Controller;

public class ShowFullTree implements Option{
    @Override
    public void executeAction(Controller controller) {
        controller.showTree();
    }
}
