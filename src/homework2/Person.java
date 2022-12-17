package homework2;

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
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", male=" + male +
                ", birthday=" + birthday +
                '}';
    }
}
