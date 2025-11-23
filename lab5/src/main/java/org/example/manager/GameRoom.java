package org.example.manager;

import org.example.exception.BudgetExceededException;
import org.example.model.Toy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Клас, що представляє ігрову кімнату.
 * Дозволяє додавати іграшки в межах бюджету, сортувати їх та шукати за параметрами.
 *
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class GameRoom {
    /** Список іграшок у кімнаті. */
    private List<Toy> toys;
    /** Максимальний бюджет на кімнату. */
    private double budgetLimit;
    /** Поточна сума вартості всіх іграшок. */
    private double currentTotalCost;

    /**
     * Конструктор ігрової кімнати.
     *
     * @param budgetLimit сума грошей, виділена на кімнату.
     */
    public GameRoom(double budgetLimit) {
        this.toys = new ArrayList<>();
        this.budgetLimit = budgetLimit;
        this.currentTotalCost = 0;
    }

    /**
     * Додає іграшку до кімнати.
     * Перевіряє, чи не перевищено бюджет.
     *
     * @param toy об'єкт іграшки, який додається.
     * @throws BudgetExceededException якщо вартість іграшки перевищує залишок бюджету.
     * @throws IllegalArgumentException якщо передано null.
     */
    public void addToy(Toy toy) throws BudgetExceededException {
        if (toy == null) {
            throw new IllegalArgumentException("Toy cannot be null");
        }
        if (currentTotalCost + toy.getPrice() > budgetLimit) {
            throw new BudgetExceededException(
                    "Cannot add " + toy.getName() + ". Budget limit exceeded! " +
                            "Current: " + currentTotalCost + ", Limit: " + budgetLimit + ", Toy Price: " + toy.getPrice()
            );
        }
        toys.add(toy);
        currentTotalCost += toy.getPrice();
    }

    /**
     * Сортує іграшки в кімнаті за зростанням ціни.
     */
    public void sortByPrice() {
        Collections.sort(toys);
    }

    /**
     * Сортує іграшки за допомогою переданого компаратора.
     * Наприклад, можна сортувати за назвою або віковою групою.
     *
     * @param comparator компаратор для сортування.
     */
    public void sort(Comparator<Toy> comparator) {
        toys.sort(comparator);
    }

    /**
     * Знаходить іграшки, що потрапляють у заданий діапазон цін.
     *
     * @param minPrice мінімальна ціна.
     * @param maxPrice максимальна ціна.
     * @return список знайдених іграшок.
     */
    public List<Toy> findToysByPriceRange(double minPrice, double maxPrice) {
        List<Toy> result = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice) {
                result.add(toy);
            }
        }
        return result;
    }

    /**
     * Отримує поточний список іграшок.
     *
     * @return список іграшок.
     */
    public List<Toy> getToys() {
        return toys;
    }

    /**
     * Отримує загальну вартість іграшок у кімнаті.
     *
     * @return поточна вартість.
     */
    public double getCurrentTotalCost() {
        return currentTotalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Game Room Content (Total Cost: " + currentTotalCost + "/" + budgetLimit + "):\n");
        for (Toy toy : toys) {
            sb.append(toy).append("\n");
        }
        return sb.toString();
    }
}
