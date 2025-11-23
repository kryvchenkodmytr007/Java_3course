package org.example.model;

/**
 * Клас, що представляє іграшку "Машинка".
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Car extends Toy {
    /** Розмір машинки (маленька, середня, велика). */
    private CarSize size;

    /**
     * Конструктор для створення машинки.
     *
     * @param name     назва.
     * @param price    ціна.
     * @param ageGroup вікова група.
     * @param size     розмір машинки.
     */
    public Car(String name, double price, AgeGroup ageGroup, CarSize size) {
        super(name, price, ageGroup);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", size=" + size +
                '}';
    }
}