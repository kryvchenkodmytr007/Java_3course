package org.example.model;

/**
 * Клас, що представляє іграшку "Лялька".
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Doll extends Toy {
    /** Матеріал, з якого зроблена лялька. */
    private String material;

    /**
     * Конструктор для створення ляльки.
     *
     * @param name     назва.
     * @param price    ціна.
     * @param ageGroup вікова група.
     * @param material матеріал ляльки.
     */
    public Doll(String name, double price, AgeGroup ageGroup, String material) {
        super(name, price, ageGroup);
        this.material = material;
    }

    @Override
    public String toString() {
        return "Doll{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", material='" + material + '\'' +
                '}';
    }
}