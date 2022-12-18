package homework2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainApp {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar releaseDate = Calendar.getInstance();
        try {
            releaseDate.setTime(sdf.parse("1988-10-01"));
        } catch (ParseException e) {
            System.out.println("Некоректный ввод или неверный формат времени");
        }
        Person mother = new Person("Ирина", "Курехина", false, (Calendar) releaseDate.clone());
        try {
            releaseDate.setTime(sdf.parse("1985-10-21"));
        } catch (ParseException e) {
            System.out.println("Некоректный ввод или неверный формат времени");
        }
        Person father = new Person("Олег", "Курехин", true, (Calendar) releaseDate.clone());
        try {
            releaseDate.setTime(sdf.parse("2012-02-01"));
        } catch (ParseException e) {
            System.out.println("Некоректный ввод или неверный формат времени");
        }
        Person child = new Person("Валерий", "Курехин", true, (Calendar) releaseDate.clone());
        Family family = new Family("Курехины");
        family.marriage(father, mother);
        family.childBirth(mother, child);
        System.out.println(family);
        UserInterface userInterface = new UserInterface();
        userInterface.startMainMenu();
    }
}
