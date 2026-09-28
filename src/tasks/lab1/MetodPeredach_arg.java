package tasks.lab1;

public class MetodPeredach_arg {
    public static void run() {
        System.out.println("\n Задание №7. Методы и передача аргументов");

        // перегрузка метода print
        System.out.println("\nПерегрузка метода print:");
        print(42);
        print(3.14);
        print("строка");
        print(new int[]{1, 2, 3});

        // varargs
        System.out.println("\nvarargs:");
        System.out.println("sum() = " + sum());
        System.out.println("sum(1) = " + sum(1));
        System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3));
        System.out.println("sum(массив 1..5) = " + sum(new int[]{1, 2, 3, 4, 5}));

        // возведение в степень: рекурсивно и итеративно
        System.out.println("\nВозведение в степень:");
        int[][] cases = {
                {2, 0}, {2, 1}, {2, 10}, {3, 4}, {5, 3}, {7, 5}
        };
        for (int[] c : cases) {
            long r = powRecursive(c[0], c[1]);
            long i = powIterative(c[0], c[1]);
            double m = Math.pow(c[0], c[1]);
            System.out.println(c[0] + "^" + c[1]
                    + ": рекурсивно = " + r
                    + ", итеративно = " + i
                    + ", Math.pow = " + (long) m);
        }
    }

    // перегрузка print
    public static void print(int x) {
        System.out.println("print(int): " + x);
    }

    public static void print(double x) {
        System.out.println("print(double): " + x);
    }

    public static void print(String s) {
        System.out.println("print(String): " + s);
    }

    public static void print(int[] arr) {
        StringBuilder sb = new StringBuilder("print(int[]): [");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    // varargs

    public static int sum(int... nums) { //произвольное число аргументов
        int s = 0;
        for (int n : nums) s += n;
        return s;
    }

    // степень: рекурсивно

    public static long powRecursive(long base, int exp) {
        if (exp < 0) throw new IllegalArgumentException("exp >= 0");
        if (exp == 0) return 1;
        return base * powRecursive(base, exp - 1);
    }

    // степень: итеративно

    public static long powIterative(long base, int exp) {
        if (exp < 0) throw new IllegalArgumentException("exp >= 0");
        long result = 1;
        for (int i = 0; i < exp; i++) result *= base;
        return result;
    }
}


//  Быстрее будет итеративная реализация
//  каждый рекурсивный вызов — это вызов метода
//  вызов метода требует времени и памяти: нужно запомнить,
//  куда вернуться, сохранить переменные и т.д.
//  В рекурсии количество таких вызовов равно степени (например, 10 для 2^10)
//  В цикле метод вызывается один раз, а дальше просто повторяются
//  те же действия внутри него, никаких лишних вызовов и сохранений
//  поэтому цикл должен работать быстрее
