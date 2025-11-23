package org.example.text;

/**
 * Клас, що представляє розділовий знак.
 * Реалізує інтерфейс SentenceMember, оскільки є частиною речення.
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Punctuation implements SentenceMember {
    /** Символ розділового знаку. */
    private final String value;

    /**
     * Конструктор класу Punctuation.
     *
     * @param value рядок або символ розділового знаку.
     */
    public Punctuation(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
