package tasks.lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;

            do {
                printMenu();

                // Защита от неверного ввода
                if (!sc.hasNextInt()) {
                    System.out.println("Ошибка: нужно ввести целое число от 0 до 7");
                    sc.next();     // убираем неверный ввод
                    choice = -1;   // сбрасываем выбор
                    continue;
                }

                choice = sc.nextInt();

                switch (choice) {
                    case 0 -> System.out.println("Выход");
                    case 1 -> CelChis_lovushki.run();
                    case 2 -> Vech_arifm.run();
                    case 3 -> Pobit_oper.run();
                    case 4 -> Obrabot_text.run();
                    case 5 -> Odnomer_massiv.run();
                    case 6 -> Mnogomer_massiv.run();
                    case 7 -> MetodPeredach_arg.run();
                    default -> System.out.println("Нет такого пункта, введите от 0 до 7");
                }

            } while (choice != 0);
        }
    }

    private static void printMenu() {
        String help = """
                =========================================================
                Задания лабораторной №1
                =========================================================
                1 - Целочисленные ловушки
                2 - Вещественная арифметика
                3 - Побитовые операции
                4 - Обработка текста
                5 - Одномерные массивы
                6 - Многомерные массивы
                7 - Методы и передача аргументов
                0 - Выход
                =========================================================
                Ваш выбор:""";
        System.out.println(help);
    }
}
