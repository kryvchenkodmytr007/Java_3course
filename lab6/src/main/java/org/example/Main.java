package org.example;

import org.example.collection.ToyArrayList;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Головний клас для демонстрації роботи власної колекції.
 * Лабораторна робота №6.
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class Main {
    /**
     * Точка входу в програму.
     * @param args аргументи командного рядка.
     */
    public static void main(String[] args) {
        System.out.println("Lab 6: Custom Collection (List implementation with Array structure)");

        ToyArrayList<Toy> myToyList = new ToyArrayList<>();
        System.out.println("Created empty list. Size: " + myToyList.size());

        // Додавання елементів
        Car car1 = new Car("Hot Wheels", 50.0, AgeGroup.SCHOOL, CarSize.SMALL);
        Doll doll1 = new Doll("Barbie", 150.0, AgeGroup.SCHOOL, "Plastic");

        myToyList.add(car1);
        myToyList.add(doll1);
        System.out.println("Added 2 elements. Size: " + myToyList.size());

        // Демонстрація конструктора з одним елементом
        Toy ball = new Ball("Soccer Ball", 45.0, AgeGroup.SCHOOL, 22.0);
        ToyArrayList<Toy> singleList = new ToyArrayList<>(ball);
        System.out.println("Created list with 1 element: " + singleList.get(0));

        // Демонстрація конструктора зі стандартною колекцією
        List<Toy> standardList = new ArrayList<>();
        standardList.add(new Cube("Rubik", 15.0, AgeGroup.SCHOOL, "Color"));
        standardList.add(new Car("Truck", 100.0, AgeGroup.TODDLER, CarSize.BIG));

        ToyArrayList<Toy> collectionList = new ToyArrayList<>(standardList);
        System.out.println("Created list from standard collection. Size: " + collectionList.size());

        // Додамо все в основний список для перевірки addAll
        myToyList.addAll(collectionList);
        myToyList.add(ball);

        System.out.println("\n--- Full List Content ---");
        for (Toy t : myToyList) {
            System.out.println(t);
        }

        // Перевірка remove
        System.out.println("\n--- Removing 'Barbie' ---");
        myToyList.remove(doll1); // Видалення за об'єктом
        System.out.println("Contains Barbie? " + myToyList.contains(doll1));

        System.out.println("\n--- Removing element at index 0 ---");
        Toy removed = myToyList.remove(0); // Видалення за індексом
        System.out.println("Removed: " + removed.getName());

        System.out.println("Current Size: " + myToyList.size());

        System.out.println("\n--- Testing Capacity Growth ---");
        ToyArrayList<Toy> growthTestList = new ToyArrayList<>();
        for (int i = 0; i < 18; i++) {
            growthTestList.add(new Cube("Cube " + i, 10 + i, AgeGroup.TODDLER, "Red"));
        }
        System.out.println("Added 18 elements. Internal array must have grown from 15 to 19 (15 * 1.3).");
        System.out.println("List size: " + growthTestList.size());
        System.out.println("Last element: " + growthTestList.get(17));
    }
}