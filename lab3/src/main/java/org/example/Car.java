package org.example;

import java.util.Objects;

/**
 * Клас, що описує сутність "Автомобіль".
 * Використовується для зберігання інформації про транспортний засіб,
 * таку як марка, модель, рік випуску, ціна та колір.
 * <p>
 * Відповідає вимогам завдання для варіанту C11 = 1.
 * </p>
 *
 * @author Dmytro Kryvchenko
 * @version 1.0
 */
public class Car {

    /**
     * Марка автомобіля (наприклад, "Toyota", "BMW").
     */
    private String brand;

    /**
     * Модель автомобіля (наприклад, "Camry", "X5").
     */
    private String model;

    /**
     * Рік випуску автомобіля.
     */
    private int year;

    /**
     * Ціна автомобіля у доларах США.
     */
    private double price;

    /**
     * Колір автомобіля.
     */
    private String color;

    /**
     * Конструктор для створення нового об'єкта автомобіля з усіма необхідними полями.
     *
     * @param brand Марка автомобіля.
     * @param model Модель автомобіля.
     * @param year  Рік випуску.
     * @param price Ціна автомобіля.
     * @param color Колір автомобіля.
     */
    public Car(String brand, String model, int year, double price, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
    }

    /**
     * Отримує марку автомобіля.
     *
     * @return Рядок, що містить назву марки.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Отримує модель автомобіля.
     *
     * @return Рядок, що містить назву моделі.
     */
    public String getModel() {
        return model;
    }

    /**
     * Отримує рік випуску автомобіля.
     *
     * @return Ціле число, що відповідає року випуску.
     */
    public int getYear() {
        return year;
    }

    /**
     * Отримує ціну автомобіля.
     *
     * @return Дійсне число, що відповідає ціні.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Отримує колір автомобіля.
     *
     * @return Рядок, що містить назву кольору.
     */
    public String getColor() {
        return color;
    }

    /**
     * Повертає рядкове представлення об'єкта автомобіля.
     * Формат виводу зручний для перегляду списку автомобілів у консолі.
     *
     * @return Рядок з інформацією про автомобіль.
     */
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    /**
     * Порівнює цей об'єкт з іншим об'єктом на рівність.
     * Два автомобілі вважаються ідентичними, якщо всі їхні поля співпадають.
     *
     * @param o Об'єкт для порівняння.
     * @return true, якщо об'єкти ідентичні; false в іншому випадку.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                Double.compare(car.price, price) == 0 &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color);
    }

    /**
     * Повертає хеш-код об'єкта.
     * Необхідний для коректної роботи в колекціях, заснованих на хешуванні.
     *
     * @return Цілочисельне значення хеш-коду.
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, price, color);
    }
}
