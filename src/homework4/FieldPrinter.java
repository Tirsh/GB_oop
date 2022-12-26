package homework4;

public class FieldPrinter {
    public static void showField(Field field){
        int line = field.getField().get(0).getX();
        for (Point point:field.getField()){
            if (line != point.getY()) {
                System.out.printf("\n");
                line = point.getY();
            }
            if (point.getValue() == -1)
                System.out.printf("# ");
            else
                System.out.printf("%-2d",point.getValue());
            System.out.printf(" ");
        }
        System.out.printf("\n");
    }
}
