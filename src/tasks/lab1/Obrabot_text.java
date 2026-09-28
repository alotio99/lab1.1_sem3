package tasks.lab1;

public class Obrabot_text {
    public static void run() {
        System.out.println("\nЗадание №4. Обработка текста");

        // 1) Палиндром
        System.out.println("Палиндром \"А роза упала на лапу Азора\": "
                + isPalindrome("А роза упала на лапу Азора"));
        System.out.println("Палиндром \"Hello\": " + isPalindrome("Hello"));

        // 2) Разворот слов
        System.out.println("Реверс \"кот съел мышь\": "
                + reverseWords("кот съел мышь"));

        // 3) Подсчёт гласных/согласных/цифр/пробелов
        countChars("Hello World 123!");

        // 4) Цезарь
        String msg = "Hello, World!";
        String enc = caesar(msg, 3);
        System.out.println("Цезарь шифр (k=3): " + enc);
        System.out.println("Цезарь расшифровка: " + caesar(enc, -3));

        // 5) Самое длинное слово
        System.out.println("Самое длинное слово в \"Java is a great programming language\": "
                + longestWord("Java is a great programming language"));
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char a = Character.toLowerCase(s.charAt(i));
            char b = Character.toLowerCase(s.charAt(j));
            if (!Character.isLetterOrDigit(a)) { i++; continue; }
            if (!Character.isLetterOrDigit(b)) { j--; continue; }
            if (a != b) return false;
            i++; j--;
        }
        return true;
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray(); //строка в массив символов
        int wordCount = 0;
        boolean inWord_now = false;
        for (char c : chars) {
            if (!Character.isWhitespace(c) && !inWord_now) { inWord_now = true; wordCount++; }
            else if (Character.isWhitespace(c)) inWord_now = false;
        }
        String[] words = new String[wordCount];
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || Character.isWhitespace(chars[i])) {
                if (sb.length() > 0) { words[idx++] = sb.toString(); sb.setLength(0); }
            } else {
                sb.append(chars[i]);
            }
        }
        // Меняем порядок
        StringBuilder out = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            out.append(words[i]);
            if (i > 0) out.append(' ');
        }
        return out.toString();
    }

    public static void countChars(String s) {
        int glasn = 0, soglas = 0, digits = 0, spaces = 0;
        String glasnSet = "aeiouyAEIOUYаеёиоуыэюяАЕЁИОУЫЭЮЯ";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); //символ на позиции
            if (Character.isWhitespace(c)) spaces++;
            else if (Character.isDigit(c)) digits++;
            else if (Character.isLetter(c)) {
                if (glasnSet.indexOf(c) >= 0) glasn++;
                else soglas++;
            }
        }
        System.out.println("Гласных = " + glasn
                + ", согласных = " + soglas
                + ", цифр = " + digits
                + ", пробелов = " + spaces);
    }

    public static String caesar(String s, int k) {
        // приводим k к диапазону 0..25 с сохранением положительного знака
        k = ((k % 26) + 26) % 26;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c >= 'a' && c <= 'z') arr[i] = (char) ('a' + (c - 'a' + k) % 26);
            else if (c >= 'A' && c <= 'Z') arr[i] = (char) ('A' + (c - 'A' + k) % 26);
        }
        return new String(arr);
    }

    public static String longestWord(String s) {
        String longW = "";
        int i = 0, n = s.length();
        while (i < n) {
            while (i < n && !Character.isLetter(s.charAt(i))) i++;
            int start = i;
            while (i < n && Character.isLetter(s.charAt(i))) i++;
            if (i > start) {
                String word = s.substring(start, i);
                if (word.length() > longW.length()) longW = word;
            }
        }
        return longW;
    }
}