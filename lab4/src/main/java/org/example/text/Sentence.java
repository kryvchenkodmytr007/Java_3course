package org.example.text;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє речення.
 * Речення складається з послідовності слів та розділових знаків.
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Sentence {
    /** Список елементів речення (слів та розділових знаків). */
    private final List<SentenceMember> sentenceMembers;

    /**
     * Конструктор за замовчуванням.
     */
    public Sentence() {
        this.sentenceMembers = new ArrayList<>();
    }

    /**
     * Додає елемент до речення.
     *
     * @param member об'єкт, що реалізує {@link SentenceMember} (Слово або Пунктуація).
     */
    public void addMember(SentenceMember member) {
        sentenceMembers.add(member);
    }

    /**
     * Отримує всі слова з речення.
     * Використовується для подальшого сортування.
     *
     * @return список об'єктів {@link Word}.
     */
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (SentenceMember member : sentenceMembers) {
            if (member instanceof Word) {
                words.add((Word) member);
            }
        }
        return words;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentenceMembers.size(); i++) {
            SentenceMember member = sentenceMembers.get(i);
            sb.append(member.toString());

            // Додаємо пробіл після слова, якщо наступний елемент не є розділовим знаком
            if (member instanceof Word && i < sentenceMembers.size() - 1
                    && sentenceMembers.get(i + 1) instanceof Word) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}