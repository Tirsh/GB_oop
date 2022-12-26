package homework4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class WaveAlgo {
    private Field field;
    private Deque<Point> queue;
    private List<Point> resultList;

    public WaveAlgo(Field field) {
        this.field = new Field(field);
        queue = new ArrayDeque<>();
    }
    private int getPointIndex(Point point){
        return field.getLength() * point.getY() + point.getX();
    }
    public List<Point> startWaveAlgo(Point from, Point to){
        Point startPoint = field.getField().get(getPointIndex(from));
        Point endPoint = field.getField().get(getPointIndex(to));
        startPoint.setValue(1);
        wavePropagation(startPoint);
        resultList = new ArrayList<>();
        pathRecovery(endPoint);
        return resultList;
    }
    public void wavePropagation(Point point){
        putPointsInQueue(point);
        if (queue.isEmpty())
            return;
        wavePropagation(queue.pollFirst());
    }
    private void putPointsInQueue(Point point){
        int index = getPointIndex(point);
        Point p;
        if (point.getY() > 0 && field.getField().get(index - field.getLength()).getValue() == 0 ){
            p = field.getField().get(index - field.getLength());
            p.setValue(point.getValue()+1);
            queue.addLast(p);
        }
        if (point.getX() <= field.getLength() - 2 && field.getField().get(index + 1).getValue() == 0){
            p = field.getField().get(index + 1);
            p.setValue(point.getValue()+1);
            queue.addLast(p);
        }
        if (point.getY() < field.getWidth() - 1 && field.getField().get(index + field.getLength()).getValue() == 0){
            p = field.getField().get(index + field.getLength());
            p.setValue(point.getValue()+1);
            queue.addLast(p);
        }
        if (point.getX() > 0 && field.getField().get(index - 1).getValue() == 0){
            p = field.getField().get(index - 1);
            p.setValue(point.getValue()+1);
            queue.addLast(p);
        }
    }
    private void pathRecovery(Point point){
        resultList.add(point);
        if (point.getValue() == 1) return;
        int index = getPointIndex(point);
        if (point.getY() > 0 && field.getField().get(index - field.getLength()).getValue() == point.getValue() - 1)
            pathRecovery(field.getField().get(index - field.getLength()));
        if (point.getX() <= field.getLength() - 2 && field.getField().get(index + 1).getValue() == point.getValue() - 1)
            pathRecovery(field.getField().get(index + 1));
        if (point.getY() < field.getWidth() - 1 && field.getField().get(index + field.getLength()).getValue() == point.getValue() - 1)
            pathRecovery(field.getField().get(index + field.getLength()));
        if (point.getX() > 0 && field.getField().get(index - 1).getValue() == point.getValue() - 1)
            pathRecovery(field.getField().get(index - 1));
    }
    public Field createWay(){
        for (Pon)
    }

    public void info(){
        for (Point point: field.getField())
            System.out.println(point);
    }

    public Field getField() {
        return field;
    }
}
