package org.example.exception;

/**
 * Виняток, що викидається, коли вартість іграшок перевищує виділений бюджет.
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class BudgetExceededException extends Exception {

    /**
     * Конструктор винятку з повідомленням.
     *
     * @param message повідомлення про помилку.
     */
    public BudgetExceededException(String message) {
        super(message);
    }
}