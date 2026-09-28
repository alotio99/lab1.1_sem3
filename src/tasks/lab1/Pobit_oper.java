package tasks.lab1;

public class Pobit_oper {
    public static void run() {
        System.out.println("\nЗадание №3. Побитовые операции");

        int a = 12;
        int b = 10;

        System.out.println("a = " + a + " (" + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + " (" + Integer.toBinaryString(b) + ")");

        System.out.println("a & b = " + (a & b)); // AND: 1 там, где в обоих битах 1
        System.out.println("a | b = " + (a | b)); // OR: 1 там, где хотя бы в одном 1
        System.out.println("a ^ b = " + (a ^ b)); // XOR: 1 там, где биты различаются
                System.out.println("~a     = " + (~a)); // инверсия всех битов (доп. код)
        System.out.println("a << 1 = " + (a << 1)); // сдвиг влево (умножение на 2)
        System.out.println("a >> 1 = " + (a >> 1)); // арифметический сдвиг вправо (сохраняет знак)
        System.out.println("a >>> 1 = " + (a >>> 1)); // логический сдвиг (слева нули)

        int neg = -8;
        System.out.println("\nДля отрицательного neg = " + neg + " (" + Integer.toBinaryString(neg) + "):");
        System.out.println("  neg >> 1  = " + (neg >> 1)
                + " (" + Integer.toBinaryString(neg >> 1) + ")"); // знаковый сдвиг — старший бит '1' тянется влево
        System.out.println("  neg >>> 1 = " + (neg >>> 1)
                + " (" + Integer.toBinaryString(neg >>> 1) + ")"); // беззнаковый сдвиг — старший бит = 0
        //>> сохраняет знак (арифметический), >>> вдвигает нули (логический)

        // Проверка чётности через &
        System.out.println("\nisEven(10) = " + isEven(10));
        System.out.println("isEven(7)  = " + isEven(7));

        // Степень двойки
        System.out.println("isStepTwo(64) = " + isStepTwo(64));
        System.out.println("isStepTwo(63) = " + isStepTwo(63));
        System.out.println("isStepTwo(1)  = " + isStepTwo(1));

        // Подсчёт единичных битов
        System.out.println("bitCount(45) = " + bitCount(45));

        // Обмен через XOR
        int x = 5, y = 9;
        System.out.println("\nДо обмена: x=" + x + ", y=" + y);
        x ^= y; y ^= x; x ^= y;
        System.out.println("После XOR-обмена: x=" + x + ", y=" + y);
    }

    private static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    private static boolean isStepTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    private static int bitCount(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
