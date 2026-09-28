package tasks.lab1;

public class Mnogomer_massiv {
    public static void run() {
        System.out.println("\n Задание №6. Многомерные массивы");

        int[][] m = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12}
        };
        System.out.println("Исходная матрица 3x4:");
        printMatrix(m);

        int[][] t = transpose(m);
        System.out.println("\nТранспонированная 4x3:");
        printMatrix(t);

        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] b = {
                {7, 8},
                {9, 10},
                {11, 12}
        };
        System.out.println("\nУмножение 2x3 * 3x2:");
        int[][] prod = multi(a, b);
        if (prod != null) printMatrix(prod);

        // Демонстрация несогласованных размеров
        System.out.println("\nПопытка умножить матрицы:");
        int[][] bad = multi(a, a); // 2x3 * 2x3 — не совпадают
        System.out.println("Результат: " + (bad == null ? "не вычислено" : "ok"));
    }

    public static void printMatrix(int[][] m) {
        if (m == null || m.length == 0) { System.out.println("(пусто)"); return; }
        // Найдём ширину столбца по максимальной длине элемента
        int width = 0;
        for (int[] row : m)
            for (int v : row)
                width = Math.max(width, String.valueOf(v).length()); //ищем макс по длине
        width += 2;

        for (int[] row : m) {
            StringBuilder sb = new StringBuilder();
            for (int v : row) sb.append(String.format("%" + width + "d", v));
            System.out.println(sb); //собираем строки и печатаем
        }
    }

    public static int[][] transpose(int[][] m) {
        if (m == null || m.length == 0) return new int[0][0];
        int rows = m.length, cols = m[0].length;
        int[][] res = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res[j][i] = m[i][j];
        return res;
    }

    public static int[][] multi(int[][] a, int[][] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            System.out.println("Ошибка: одна из матриц пуста");
            return null;
        }
        int aCols = a[0].length;
        int bRows = b.length;
        if (aCols != bRows) {
            System.out.println("Ошибка: размеры не согласованы: A="
                    + a.length + "x" + aCols
                    + ", B=" + bRows + "x" + b[0].length);
            return null;
        }
        int aRows = a.length;
        int bCols = b[0].length;
        int[][] c = new int[aRows][bCols];
        for (int i = 0; i < aRows; i++)
            for (int j = 0; j < bCols; j++)
                for (int k = 0; k < aCols; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }
}
