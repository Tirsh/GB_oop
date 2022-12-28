package homework4;

/**
 * Компонента отображения экземпляров Field
 * Статический метод showField - выводит информацию в консоль
 */
public class FieldPrinter {
    public static void showField(Field field){
        System.out.printf("%-2s| ", "\\");
        for (int i = 0; i < field.getLength(); i++) {
            System.out.printf("%-2d", i);
            System.out.print(" ");
        }
        System.out.printf("\n%-2s| ", "-");
        for (int i = 0; i < field.getLength(); i++) {
            System.out.printf("%-2s", "-");
            System.out.print(" ");
        }
        int line = -1;
        for (Point point:field.getField()){
            if (line != point.getY()) {
                line = point.getY();
                System.out.printf("\n%-2d| ", line);
            }
            if (point.getValue() == -1)
                System.out.print("# ");
            else
                System.out.printf("%-2d",point.getValue());
            System.out.print(" ");
        }
        System.out.print("\n\n");
    }
}
