package tasks.lab1;

import java.util.Arrays;
import java.util.Random;

public class Odnomer_massiv {
    public static void run() {
        System.out.println("\nЗадание №5. Одномерные массивы ");

        int n = 15;
        int[] arr = new int[n];
        Random rnd = new Random(10);
        for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(100) - 50;

        System.out.println("Исходный массив: " + Arrays.toString(arr));

        // min / max / сред. арифм
        int min = arr[0], max = arr[0];
        long sum = 0;
        for (int v : arr) {
            if (v < min) min = v;
            if (v > max) max = v;
            sum += v;
        }
        double avg = (double) sum / arr.length;
        System.out.println("min = " + min + ", max = " + max + ", avg = " + avg);

        // выбрана сортировка вставками
        // берутся элементы из неотсортированной части и вставляются в отсортированную
        int[] copy = arr.clone();
        insertionSort(copy);
        System.out.println("После сортировки вставками: " + Arrays.toString(copy));

        // Разницы
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};
        int[] a3 = a1;

        System.out.println("\narr1 == arr2 : " + (a1 == a2)); // сравниваются ссылки
        System.out.println("arr1.equals(arr2) : " + a1.equals(a2)); // у массивов equals не переопределён — снова ссылки
        System.out.println("Arrays.equals(arr1, arr2) : " + Arrays.equals(a1, a2)); // поэлементное сравнение
        System.out.println("arr1 == arr3 : " + (a1 == a3)); // одна и та же ссылка
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
