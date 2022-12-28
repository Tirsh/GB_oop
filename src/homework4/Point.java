package homework4;

/**
 * Компонет Point - точка
 * имеет две координаты: x, y
 * и значение value
 */
public class Point {
    private final int x;
    private final int y;
    private int value;

    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
    public Point(int x, int y){
        this(x, y, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}
