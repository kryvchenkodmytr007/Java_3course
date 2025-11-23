package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Головний клас для виконання лабораторної роботи №3.
 * Містить виконавчий метод, де створюється масив об'єктів {@link Car},
 * виконується їх сортування та пошук заданого елемента.
 *
 * @author Dmytro Kryvchenko
 * @version 1.0
 */
public class Main {

    /**
     * Точка входу в програму.
     * Виконує створення масиву автомобілів, сортування та пошук згідно з завданням.
     * <p>
     * Алгоритм сортування:
     * 1. За зростанням року випуску ({@code year}).
     * 2. За спаданням ціни ({@code price}), якщо роки однакові.
     * </p>
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        /*
         * Створення масиву об'єктів класу Car.
         * Дані задані безпосередньо в коді для демонстрації роботи.
         */
        Car[] cars = {
                new Car("Toyota", "Camry", 2020, 25000.0, "White"),
                new Car("BMW", "X5", 2018, 45000.0, "Black"),
                new Car("Tesla", "Model 3", 2022, 55000.0, "Red"),
                new Car("Honda", "Civic", 2020, 22000.0, "Blue"),
                new Car("Ford", "Mustang", 2018, 30000.0, "Yellow"),
                new Car("Audi", "A4", 2022, 40000.0, "Grey")
        };

        System.out.println("Початковий масив автомобілів:");
        printCars(cars);

        /*
         * Сортування масиву.
         * Використовується Arrays.sort з компаратором.
         * Первинне сортування: getYear.
         * Вторинне сортування: getPrice.
         */
        Arrays.sort(cars, Comparator
                .comparingInt(Car::getYear)
                .thenComparing((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice())));

        System.out.println("\nВідсортований масив (Рік: зростання, Ціна: спадання):");
        printCars(cars);

        /*
         * Створення об'єкта-зразка для пошуку.
         * Шукаємо автомобіль, який ідентичний "Honda Civic" з масиву.
         */
        Car searchTarget = new Car("Honda", "Civic", 2020, 22000.0, "Blue");
        System.out.println("\nШукаємо автомобіль: " + searchTarget);

        /*
         * Пошук об'єкта в масиві.
         * Оскільки масив не відсортований повністю за всіма полями для binarySearch,
         * використовуємо лінійний пошук.
         */
        boolean found = false;
        for (Car car : cars) {
            if (car.equals(searchTarget)) {
                System.out.println("Знайдено ідентичний об'єкт у масиві: " + car);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Об'єкт не знайдено.");
        }
    }

    /**
     * Допоміжний метод для виведення масиву автомобілів у консоль.
     *
     * @param cars Масив об'єктів {@link Car}, який необхідно вивести.
     */
    private static void printCars(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}