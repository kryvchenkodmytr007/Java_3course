package org.example;

import org.example.text.Text;
import org.example.text.Word;

import java.util.Comparator;
import java.util.List;

/**
 * Головний клас програми для демонстрації роботи зі структурою тексту.
 * Виконує сортування слів тексту за кількістю входжень заданого символу.
 *
 * @author Kryvchenko Dmytro
 * @version 1.1
 */
public class Main {

    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
            // Вхідний текст з зайвими пробілами та табуляціями для демонстрації очищення
            String rawText = "Java is an   amazing programming language! It has   powerful features.";

            // Символ, за кількістю якого будемо сортувати
            char targetChar = 'a';

            System.out.println("Original Text:\n'" + rawText + "'");
            System.out.println("Target character: '" + targetChar + "'");
            System.out.println("--------------------------------------------------");

            // Створення об'єкта Text (всередині відбувається парсинг і очищення)
            Text textStructure = new Text(rawText);

            System.out.println("Processed Text (Object Representation):");
            System.out.println(textStructure);
            System.out.println("--------------------------------------------------");

            // Отримуємо список об'єктів Word
            List<Word> words = textStructure.getAllWords();

            if (words.isEmpty()) {
                System.out.println("No words found.");
                return;
            }

            // Сортування слів за допомогою Comparator
            words.sort(Comparator.comparingLong(word -> word.countOccurrences(targetChar)));

            // Виведення результату
            System.out.println("Words sorted by occurrence count of '" + targetChar + "' (ascending):");
            for (Word word : words) {
                System.out.printf("%-15s (count: %d)%n", word, word.countOccurrences(targetChar));
            }

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}