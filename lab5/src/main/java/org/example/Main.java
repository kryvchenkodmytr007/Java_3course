package org.example;

import org.example.exception.BudgetExceededException;
import org.example.manager.GameRoom;
import org.example.model.*;

import java.util.List;

/**
 * Головний клас для демонстрації роботи програми (Варіант 12).
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Main {

    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка.
     */
    public static void main(String[] args) {
        System.out.println("Variant 12: Game Room implementation.");

        // Створення ігрової кімнати з бюджетом 500 у.о.
        GameRoom gameRoom = new GameRoom(500.0);

        try {
            // Наповнення кімнати іграшками
            // Додаємо машинки різних розмірів
            gameRoom.addToy(new Car("Hot Wheels", 50.5, AgeGroup.SCHOOL, CarSize.SMALL));
            gameRoom.addToy(new Car("Monster Truck", 120.0, AgeGroup.PRESCHOOL, CarSize.BIG));
            gameRoom.addToy(new Car("Police Sedan", 80.0, AgeGroup.TODDLER, CarSize.MEDIUM));

            // Додаємо ляльки
            gameRoom.addToy(new Doll("Barbie", 150.0, AgeGroup.SCHOOL, "Plastic"));
            gameRoom.addToy(new Doll("Rag Doll", 30.0, AgeGroup.TODDLER, "Fabric"));

            // Додаємо м'ячі та кубики
            gameRoom.addToy(new Ball("Soccer Ball", 45.0, AgeGroup.SCHOOL, 22.0));
            gameRoom.addToy(new Cube("Rubik's Cube", 15.0, AgeGroup.SCHOOL, "Multicolor"));

            // Спроба додати занадто дорогу іграшку для перевірки виключення
            // Бюджет вже використано на: 50.5+120+80+150+30+45+15 = 490.5
            // Залишок: 9.5
            System.out.println("Adding expensive toy to provoke exception...");
            gameRoom.addToy(new Car("Tesla Model Toy", 100.0, AgeGroup.SCHOOL, CarSize.MEDIUM));

        } catch (BudgetExceededException e) {
            System.err.println("Exception caught: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid argument: " + e.getMessage());
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("Initial list of toys in the room:");
        System.out.println(gameRoom);

        // Сортування іграшок
        System.out.println("--------------------------------------------------");
        System.out.println("Sorting toys by price (Ascending):");
        gameRoom.sortByPrice();
        for (Toy t : gameRoom.getToys()) {
            System.out.println(t);
        }

        // Пошук іграшок у діапазоні
        double minRange = 20.0;
        double maxRange = 60.0;
        System.out.println("--------------------------------------------------");
        System.out.println("Finding toys with price between " + minRange + " and " + maxRange + ":");
        List<Toy> foundToys = gameRoom.findToysByPriceRange(minRange, maxRange);

        if (foundToys.isEmpty()) {
            System.out.println("No toys found in this range.");
        } else {
            for (Toy t : foundToys) {
                System.out.println(t);
            }
        }
    }
}