package homework1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        MovieDB movieDB = new MovieDB(List.of(
                new Movie("Зеленая миля", "драма", new GregorianCalendar(1999, Calendar.DECEMBER, 6), "США", new String[] {
                    "Том Хэнкс", "Дэвид Морс", "Бонни Хант", "Майкл Кларк Дункан"} ),
                new Movie("Бойцовский клуб", "триллер", new GregorianCalendar(2000, Calendar.JANUARY, 13), "США", new String[] {
                        "Эдвард Нортон", "Брэд Питт", "Хелена Бонем Картер", "Мит Лоаф"} ),
                new Movie("Матрица", "фантастика", new GregorianCalendar(1999, Calendar.MARCH, 24), "США", new String[] {
                        "Киану Ривз", "Лоренс Фишбёрн", "Кэрри-Энн Мосс", "Хьюго Уивинг"} )

        ));

        System.out.println(movieDB.getAll());
        System.out.println(movieDB.getByTitle("бойц"));

    }
}
