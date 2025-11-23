package org.example.text;

/**
 * Інтерфейс-маркер для елементів, з яких складається речення.
 * Дозволяє зберігати слова та розділові знаки в одній колекції.
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public interface SentenceMember {
    /**
     * Повертає рядкове представлення елемента.
     * @return рядкове значення елемента.
     */
    String toString();
}
