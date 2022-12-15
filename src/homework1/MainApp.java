package homework1;

public class MainApp {
    public static void main(String[] args) {
        MovieDB movieDB = new MovieDB("src/homework1/data.db");
        MainUI mainUI = new MainUI(movieDB);
        mainUI.startMainMenu();
    }
}
