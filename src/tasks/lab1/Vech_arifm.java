package tasks.lab1;

public class Vech_arifm {
    public static void run() {
        System.out.println("\n Задание №2. Вещественная арифметика");

        // 1) 0.1 + 0.2 != 0.3, потому что 0.1 и 0.2 не представимы точно в плавающей точке
        double sum = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 = " + sum);
        System.out.println("sum == 0.3 -> " + (sum == 0.3));

        // 2
        double acc = 0.0;
        for (int i = 0; i < 10; i++) acc += 0.1;
        System.out.println("\nСумма 10 раз по 0.1 = " + acc);
        System.out.println("acc == 1.0 -> " + (acc == 1.0)); // накопленная погрешность

        // 3
        double eps = 1e-9;
        System.out.println("\nСравнение с epsilon = " + eps + " :");
        System.out.println("equalsEps(0.1 + 0.2, 0.3) = " + equalsEps(0.1 + 0.2, 0.3, eps));
        System.out.println("equalsEps(10 * 0.1, 1.0) = " + equalsEps(acc, 1.0, eps));

        // 4
        double inf  =  1.0 / 0.0;
        double negInf = -1.0 / 0.0;
        double nan  =  0.0 / 0.0;
        System.out.println("\n1.0/0.0 = " + inf);
        System.out.println("-1.0/0.0 = " + negInf);
        System.out.println("0.0/0.0 = " + nan);
        System.out.println("NaN == NaN - " + (nan == nan)); // NaN не равен сам себе

        // 5
        double v = 2.7, w = -2.7;
        System.out.println("\nДля " + v + " :");
        System.out.println("(int) = " + (int) v); // двигается к нулю
        System.out.println("round = " + Math.round(v)); // к ближайшему целому
        System.out.println("floor = " + Math.floor(v)); // округление вниз
        System.out.println("ceil = " + Math.ceil(v)); // округление вверх

        System.out.println("Для " + w + " :");
        System.out.println("  (int)  = " + (int) w); // двигается к нулю
        System.out.println("  round  = " + Math.round(w)); // к ближайшему целому
        System.out.println("  floor  = " + Math.floor(w)); // округление вниз
        System.out.println("  ceil   = " + Math.ceil(w)); // округление вверх

        // 6
        float  f = 0.0f;
        double d = 0.0;
        for (int i = 0; i < 100_000; i++) {
            f += 0.1f;
            d += 0.1;
        }
        System.out.println("\nСумма 100000 * 0.1:");
        System.out.println("float = " + f); // ~7 значащих цифр
        System.out.println("double = " + d); // ~15-16 значащих цифр
    }

    public static boolean equalsEps(double a, double b, double eps) {
        return Math.abs(a - b) <= eps;
    }
}

