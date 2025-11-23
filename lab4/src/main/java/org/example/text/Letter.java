package org.example.text;

/**
 * Клас, що представляє окрему літеру.
 * Є складовою частиною слова.
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Letter {
    /** Значення літери. */
    private final char value;

    /**
     * Конструктор класу Letter.
     *
     * @param value символ літери.
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Отримує значення літери.
     *
     * @return символ літери.
     */
    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
