package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введіть кількість рядків (M): ");
            int rows = scanner.nextInt();

            System.out.print("Введіть кількість стовпців (N): ");
            int cols = scanner.nextInt();

            char[][] matrixA = new char[rows][cols];
            char[][] matrixB = new char[rows][cols];

            fillMatrixWithRandomChars(matrixA);
            fillMatrixWithRandomChars(matrixB);

            System.out.println("Матриця A:");
            printMatrix(matrixA);
            System.out.println("Матриця B:");
            printMatrix(matrixB);

            // 2. Виконання дії з матрицями (C = A + B)
            // Перевірка на сумісність розмірностей
            if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
                throw new IllegalArgumentException("Розмірності матриць не співпадають для додавання.");
            }

            char[][] matrixC = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // char + char = int. Ми приводимо результат назад до char.
                    matrixC[i][j] = (char) (matrixA[i][j] + matrixB[i][j]);
                }
            }

            System.out.println("Матриця C (Результат A + B):");
            printMatrix(matrixC);
            printMatrixAsInts(matrixC);

            // 3. Дія з матрицею C: Обчислити суму найменших елементів кожного рядка
            long sumOfMinElements = 0;

            for (int i = 0; i < matrixC.length; i++) {
                char minInRow = matrixC[i][0];

                for (int j = 1; j < matrixC[i].length; j++) {
                    if (matrixC[i][j] < minInRow) {
                        minInRow = matrixC[i][j];
                    }
                }

                System.out.println("Найменший елемент у рядку " + i + ": "
                        + minInRow + " (код: " + (int)minInRow + ")");
                sumOfMinElements += minInRow;
            }

            System.out.println("Сума найменших елементів кожного рядка: " + sumOfMinElements);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка логіки: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Помилка доступу до масиву: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Матриця не ініціалізована: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Виникла непередбачувана помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Заповнює матрицю випадковими символами.
     * Використовуємо діапазон ASCII символів
     */
    private static void fillMatrixWithRandomChars(char[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Генеруємо випадковий символ у видимому діапазоні ASCII
                matrix[i][j] = (char) (random.nextInt(94) + 33);
            }
        }
    }

    /**
     * Виводить матрицю символів у консоль.
     */
    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Виводить матрицю як цілі числа
     */
    private static void printMatrixAsInts(char[][] matrix) {
        System.out.println("(Числове представлення матриці C):");
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print((int)element + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}