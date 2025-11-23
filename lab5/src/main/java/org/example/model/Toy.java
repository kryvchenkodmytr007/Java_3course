package org.example.model;

/**
 * Абстрактний клас, що представляє загальну сутність "Іграшка".
 * Містить спільні поля для всіх типів іграшок.
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public abstract class Toy implements Comparable<Toy> {
    /** Назва іграшки. */
    private String name;
    /** Вартість іграшки. */
    private double price;
    /** Вікова група, для якої призначена іграшка. */
    private AgeGroup ageGroup;

    /**
     * Конструктор для створення іграшки.
     *
     * @param name     назва іграшки.
     * @param price    ціна іграшки.
     * @param ageGroup вікова група.
     */
    public Toy(String name, double price, AgeGroup ageGroup) {
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
    }

    /**
     * Отримує ціну іграшки.
     *
     * @return ціна у грошових одиницях.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Отримує назву іграшки.
     *
     * @return назва іграшки.
     */
    public String getName() {
        return name;
    }

    /**
     * Отримує вікову групу.
     *
     * @return об'єкт AgeGroup.
     */
    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    /**
     * Реалізація методу порівняння за замовчуванням (за ціною).
     *
     * @param other інша іграшка для порівняння.
     * @return результат порівняння цін.
     */
    @Override
    public int compareTo(Toy other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return "Toy{name='" + name + "', price=" + price + ", ageGroup=" + ageGroup + "}";
    }
}