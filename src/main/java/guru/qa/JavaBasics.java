package guru.qa;

public class JavaBasics {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        // Арифметические операции над двумя примитивами типа int
        int sum = a + b;         // Сложение
        int difference = a - b;  // Вычитание
        int product = a * b;     // Умножение
        int quotient = a / b;    // Деление

        System.out.println("Сложение: " + sum);
        System.out.println("Вычитание: " + difference);
        System.out.println("Умножение: " + product);
        System.out.println("Деление: " + quotient);

        int x = 10;
        double y = 4.5;

        // Арифметические операции с int и double в одном выражении
        double result = x + y * 2 - (x / 2.0);

        System.out.println("Результат выражения: " + result);

        // Логические операции
        boolean isALessThanB = a < b;       // Проверка, меньше ли a, чем b
        boolean isAGreaterThanB = a > b;    // Проверка, больше ли a, чем b
        boolean isAEqualOrGreaterThanB = a >= b; // Проверка, больше или равно ли a, чем b
        boolean isALessOrEqualToB = a <= b; // Проверка, меньше или равно ли a, чем b

        System.out.println("a < b: " + isALessThanB);
        System.out.println("a > b: " + isAGreaterThanB);
        System.out.println("a >= b: " + isAEqualOrGreaterThanB);
        System.out.println("a <= b: " + isALessOrEqualToB);

        // Переполнение для float
        float floatMax = Float.MAX_VALUE;
        float floatOverflow = floatMax * 2; // Ожидаемое значение: Infinity

        System.out.println("Float Max Value: " + floatMax);
        System.out.println("Float Overflow (Max * 2): " + floatOverflow);

        // Переполнение для double
        double doubleMax = Double.MAX_VALUE;
        double doubleOverflow = doubleMax * 2; // Ожидаемое значение: Infinity

        System.out.println("Double Max Value: " + doubleMax);
        System.out.println("Double Overflow (Max * 2): " + doubleOverflow);
    }
}
