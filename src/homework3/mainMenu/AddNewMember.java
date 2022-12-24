package homework3.mainMenu;

import homework3.Controller;
import homework3.model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class AddNewMember implements Option {
    @Override
    public void executeAction(Controller controller) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String secondName = scanner.nextLine();
        System.out.println("Пол мужской (Y,n)");
        String result = scanner.nextLine();
        boolean sex = result.equals("") || result.equals("Y");
        Calendar bDay = Calendar.getInstance();
        while(true) {
            System.out.println("Введите дату рождения в формате (yyyy-mm-dd):");
            String birthDay = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                bDay.setTime(sdf.parse(birthDay));
                break;
            } catch (ParseException e) {
                System.out.println("Некоректный ввод или неверный формат времени");
            }
        }
        Person person = new Person(firstName, secondName, sex, bDay);
        controller.addPerson(person);
    }
}
