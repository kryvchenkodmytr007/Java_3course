package org.example.text;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє слово.
 * Слово складається з масиву (списку) літер {@link Letter}.
 * Реалізує інтерфейс {@link SentenceMember}.
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Word implements SentenceMember {
    /** Список літер, з яких складається слово. */
    private final List<Letter> letters;

    /**
     * Конструктор, що створює об'єкт Word з рядка.
     *
     * @param wordString рядок, який потрібно перетворити на об'єкт Word.
     */
    public Word(String wordString) {
        this.letters = new ArrayList<>();
        for (char c : wordString.toCharArray()) {
            this.letters.add(new Letter(c));
        }
    }

    /**
     * Підраховує кількість входжень заданого символу в слові.
     * Метод ігнорує регістр (case-insensitive).
     *
     * @param targetChar символ для пошуку.
     * @return кількість входжень символу.
     */
    public long countOccurrences(char targetChar) {
        char lowerTarget = Character.toLowerCase(targetChar);
        return letters.stream()
                .map(Letter::getValue)
                .filter(c -> Character.toLowerCase(c) == lowerTarget)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getValue());
        }
        return sb.toString();
    }
}