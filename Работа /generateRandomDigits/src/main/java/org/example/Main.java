package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        // Первый поток для генерации случайных чисел
        Runnable generateNumbers = () -> {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                numbers.add(random.nextInt(1000));
            }
            System.out.println("Сгенерированный список:");
            System.out.println(numbers);
        };

        // Второй поток для сортировки чисел
        Runnable sortNumbers = () -> {
            try {
                Thread.sleep(1000); // Ждем 1 секунду, чтобы первый поток успел сгенерировать числа
                Collections.sort(numbers);
                System.out.println("\nСортированный список:");
                System.out.println(numbers);
            } catch (InterruptedException e) {
                System.out.println("Ошибка в потоке сортировки");
            }
        };

        Thread generatorThread = new Thread(generateNumbers);
        Thread sorterThread = new Thread(sortNumbers);

        generatorThread.start();
        sorterThread.start();
    }
}
