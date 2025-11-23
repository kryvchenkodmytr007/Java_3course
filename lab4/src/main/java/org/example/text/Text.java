package org.example.text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Клас, що представляє текст.
 * Текст складається з масиву (списку) речень {@link Sentence}.
 * Також містить логіку парсингу рядка у структуру класів.
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Text {
    /** Список речень, з яких складається текст. */
    private final List<Sentence> sentences;

    /**
     * Конструктор тексту.
     * Виконує очищення тексту (заміна табуляцій та зайвих пробілів) та парсинг.
     *
     * @param rawText вхідний рядок тексту.
     */
    public Text(String rawText) {
        this.sentences = new ArrayList<>();
        // 1. Замінити послідовність табуляцій та пробілів одним пробілом.
        String cleanedText = rawText.replaceAll("[\\s\\t]+", " ").trim();
        parseText(cleanedText);
    }

    /**
     * Парсить очищений текст на речення, а речення — на слова та розділові знаки.
     *
     * @param text рядок тексту.
     */
    private void parseText(String text) {

        // Розбиваємо текст на токени (слова та знаки)
        Pattern pattern = Pattern.compile("([\\w]+)|([.?!,;:])");
        Matcher matcher = pattern.matcher(text);

        Sentence currentSentence = new Sentence();

        while (matcher.find()) {
            String wordPart = matcher.group(1);
            String punctuationPart = matcher.group(2);

            if (wordPart != null) {
                currentSentence.addMember(new Word(wordPart));
            } else if (punctuationPart != null) {
                currentSentence.addMember(new Punctuation(punctuationPart));
                // Якщо це знак кінця речення, зберігаємо речення і починаємо нове
                if (punctuationPart.matches("[.?!]")) {
                    sentences.add(currentSentence);
                    currentSentence = new Sentence();
                }
            }
        }
        // Додаємо останнє речення, якщо воно не пусте
        if (!currentSentence.toString().isEmpty()) {
            sentences.add(currentSentence);
        }
    }

    /**
     * Отримує всі слова з усього тексту.
     *
     * @return загальний список слів тексту.
     */
    public List<Word> getAllWords() {
        List<Word> allWords = new ArrayList<>();
        for (Sentence sentence : sentences) {
            allWords.addAll(sentence.getWords());
        }
        return allWords;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}