package org.example.model;

/**
 * Клас, що представляє іграшку "Кубик".
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Cube extends Toy {
    /** Колір кубика. */
    private String color;

    /**
     * Конструктор кубика.
     *
     * @param name     назва.
     * @param price    ціна.
     * @param ageGroup вікова група.
     * @param color    колір.
     */
    public Cube(String name, double price, AgeGroup ageGroup, String color) {
        super(name, price, ageGroup);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", color='" + color + '\'' +
                '}';
    }
}