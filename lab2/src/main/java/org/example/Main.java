package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {

            String predefinedText = "Java is an amazing programming language with powerful features for developers";

            // Символ, за кількістю якого будемо сортувати
            char targetChar = 'a';

            System.out.println("Using predefined text: \"" + predefinedText + "\"");
            System.out.println("Target character for sorting: '" + targetChar + "'");

            StringBuilder text = new StringBuilder(predefinedText);

            // Розбиття тексту на слова
            List<StringBuilder> words = splitTextIntoWords(text);

            if (words.isEmpty()) {
                System.out.println("No words found in the text.");
                return;
            }

            System.out.println("\nWords before sorting:");
            printList(words);

            // 3. Сортування слів
            // Використовуємо компаратор для порівняння кількості входжень символу
            words.sort(new Comparator<StringBuilder>() {
                @Override
                public int compare(StringBuilder sb1, StringBuilder sb2) {
                    long count1 = countOccurrences(sb1, targetChar);
                    long count2 = countOccurrences(sb2, targetChar);

                    // Сортування за зростанням
                    return Long.compare(count1, count2);
                }
            });

            // Виведення результату
            System.out.println("\nWords sorted by occurrence count of '" + targetChar + "' (ascending):");
            for (StringBuilder word : words) {
                System.out.println(word + " (count: " + countOccurrences(word, targetChar) + ")");
            }

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<StringBuilder> splitTextIntoWords(StringBuilder text) {
        List<StringBuilder> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                currentWord.append(c);
            } else {

                if (currentWord.length() > 0) {
                    words.add(currentWord);
                    currentWord = new StringBuilder();
                }
            }
        }

        if (currentWord.length() > 0) {
            words.add(currentWord);
        }

        return words;
    }

    private static long countOccurrences(StringBuilder sb, char target) {
        long count = 0;
        char targetLower = Character.toLowerCase(target);

        for (int i = 0; i < sb.length(); i++) {
            if (Character.toLowerCase(sb.charAt(i)) == targetLower) {
                count++;
            }
        }
        return count;
    }

    private static void printList(List<StringBuilder> list) {
        for (StringBuilder sb : list) {
            System.out.print(sb + " ");
        }
        System.out.println();
    }
}