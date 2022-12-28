package homework4;

import java.util.ArrayList;
import java.util.List;

/**
 * Компонет Field - поле.
 * Представляет из себя список Point
 * Имеет параметры длинна - length, и ширина - width
 * Иммет метод сборки поля из двумерного массива int[][]
 */
public class Field {
    private final List<Point> field;
    private final int width;
    private final int length;


    public Field(int[][] field) {
        this.field = mapToPointField(field);
        width = field.length;
        length = field[0].length;
    }

    public Field(Field field) {
        this.field = new ArrayList<>(field.length * field.width);
        for (Point point: field.field)
            this.field.add(new Point(point.getX(), point.getY(), point.getValue()));
        this.length = field.length;
        this.width = field.width;
    }

    private List<Point> mapToPointField(int[][] field){
        List<Point> fieldList = new ArrayList<>(field.length * field[0].length);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                fieldList.add(new Point(j, i, field[i][j]));
            }
        }
        return fieldList;
    }

    public List<Point> getField() {
        return field;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Field{" + length + " x " + width + '}';
    }
}
