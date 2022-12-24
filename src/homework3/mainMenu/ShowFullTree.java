package homework3.mainMenu;

import homework3.Controller;

public class ShowFullTree implements Option {
    @Override
    public void executeAction(Controller controller) {
        controller.showTree();
    }
}
