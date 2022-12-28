package homework4;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
//        Инициализация лабиринта
        Field field = new Field(new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, -1, 0, 0, -1, -1, 0},
                {0, -1, -1, 0, -1, 0, 0},
                {0, 0, -1, 0, 0, 0, 0},
                {0, 0, -1, -1, 0, -1, -1},
                {0, 0, 0, 0, 0, 0, 0},
        });

        System.out.println("Вводим поле: " + field);
        FieldPrinter.showField(field);
        Point from = new Point(0,0); // точка начала пути
        Point to= new Point(6,5); // точка конца пути
        System.out.println("Запуск волнового алгоритма поиск кратчайшего пути от " + from + " до " + to + " :");
//      Инициализация и запус волнового алгоритма для двух точек
        WaveAlgo waveAlgo = new WaveAlgo(field);
        List<Point> result = waveAlgo.startWaveAlgo(from, to);
        FieldPrinter.showField(waveAlgo.getField());
        System.out.println("Кратчайший путь от " + from + " до " + to + " :");
        System.out.println(result);
    }
}
