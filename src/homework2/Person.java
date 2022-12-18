package homework2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private boolean male;
    private Calendar birthday;

    public Person(String firstName, String lastName, boolean male, Calendar birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.male = male;
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + (male? "male":"woman") + '\'' +
                ", birthday=" + sdf.format(birthday.getTime());
    }
}
