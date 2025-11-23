package org.example.model;

/**
 * Клас, що представляє іграшку "М'яч".
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Ball extends Toy {
    /** Діаметр м'яча в сантиметрах. */
    private double diameterCm;

    /**
     * Конструктор м'яча.
     *
     * @param name       назва.
     * @param price      ціна.
     * @param ageGroup   вікова група.
     * @param diameterCm діаметр у см.
     */
    public Ball(String name, double price, AgeGroup ageGroup, double diameterCm) {
        super(name, price, ageGroup);
        this.diameterCm = diameterCm;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", diameter=" + diameterCm + "cm" +
                '}';
    }
}