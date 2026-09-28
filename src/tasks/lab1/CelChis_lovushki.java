package tasks.lab1;

public class CelChis_lovushki {
    public static void run() {
        System.out.println("\n Задание №1. Целочисленные ловушки");

        // 1
        System.out.println("byte: " + Byte.MIN_VALUE + " ... " + Byte.MAX_VALUE);
        System.out.println("short: " + Short.MIN_VALUE + " ... " + Short.MAX_VALUE);
        System.out.println("int: " + Integer.MIN_VALUE + " ... " + Integer.MAX_VALUE);
        System.out.println("long: " + Long.MIN_VALUE + " ... " + Long.MAX_VALUE);

        // 2
        int rez_test = Integer.MAX_VALUE + 1;
        System.out.println("\nInteger.MAX_VALUE + 1 = " + rez_test
                + "  // переполнение: значение становится MIN_VALUE");

        // 3
        int intMax2 = Integer.MAX_VALUE * 2;                       // переполнение
        long longMax2 = (long) Integer.MAX_VALUE * 2;              // без переполнения
        System.out.println("Integer.MAX_VALUE * 2 (int)  = " + intMax2
                + "  // int переполнился (32 бита)");
        System.out.println("Integer.MAX_VALUE * 2 (long) = " + longMax2
                + "  // long вмещает 64 бита, переполнения нет");

        // 4
        System.out.println("\n5 / 2   = " + (5 / 2)  + "  // целочисленное деление, дробная часть отбрасывается");
        System.out.println("-5 / 2  = " + (-5 / 2) + "  // округление к нулю");
        System.out.println("5 % 2   = " + (5 % 2)  + "  // знак остатка = знак делимого");
        System.out.println("-5 % 2  = " + (-5 % 2) + "  // остаток отрицательный");

        // 5
        long big = Integer.MAX_VALUE + 100L;
        int prived = (int) big;
        System.out.println("\nlong big = " + big
                + "\n(int) big = " + prived
                + "  // взяли младшие 32 бита — получаем отрицательное число");

        // 6
        char c = 'A';
        char next = (char) (c + 1);
        int sum = 'A' + 'B';
        char sumChar = (char) ('A' + 'B');
        System.out.println("\nСледующая буква после 'A': " + next);
        System.out.println("'A' + 'B' как int: " + sum);
        System.out.println("'A' + 'B' как char: " + sumChar);

        // 7
        System.out.println("\nПроверка переполнения при сложении int:");
        int a1 = Integer.MAX_VALUE, b1 = 1;
        System.out.println(a1 + " + " + b1
                + " -> overflow = " + perepoln_plus(a1, b1));

        int a2 = 100, b2 = 200;
        System.out.println(a2 + " + " + b2
                + " -> overflow = " + perepoln_plus(a2, b2)
                + " (результат " + (a2 + b2) + ")");

        int a3 = Integer.MIN_VALUE, b3 = -1;
        System.out.println(a3 + " + " + b3
                + " -> overflow = " + perepoln_plus(a3, b3));

        int a4 = -50, b4 = 30;
        System.out.println(a4 + " + " + b4
                + " -> overflow = " + perepoln_plus(a4, b4)
                + " (результат " + (a4 + b4) + ")");
    }

    public static boolean perepoln_plus(int a, int b) {
        int sum = a + b;
        // a > 0 и b > 0, но sum <= 0 переполнение вверх
        if (a > 0 && b > 0 && sum <= 0) return true;

        // a < 0 и b < 0, но sum >= 0  переполнение вниз
        if (a < 0 && b < 0 && sum >= 0) return true;

        return false;
    }
}

