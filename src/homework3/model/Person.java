package homework3.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Основной класс модели генеалогисечкого древа
 * Реализует отдельновзятого человека
 */
public class Person implements Serializable {
    private final String firstName;
    private final String lastName;
    private final boolean male;
    private final Calendar birthday;

    public Person(String firstName, String lastName, boolean male, Calendar birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.male = male;
        this.birthday = birthday;
    }

    public boolean isMale() {
        return male;
    }
    public void showPerson(String sep){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sep + firstName);
        System.out.println(sep + lastName);
        System.out.println(sep + "male: " + male);
        System.out.println(sep + sdf.format(birthday.getTime()));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return firstName + '\n' +
               lastName + '\n' +
               "male: "+ male + '\n' +
               sdf.format(birthday.getTime());
    }
}
