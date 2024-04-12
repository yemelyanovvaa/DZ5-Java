package org.example;

import org.example.service.Product;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        performDeserialization();
    }

    private static void performDeserialization() {
        try {
            // Получение пути к файлу для десериализации от пользователя
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            boolean isValid = false;
            String filePath = "";

            while (!isValid) {
                System.out.println("Введите путь к файлу для десериализации:");
                filePath = reader.readLine();
                isValid = isValidPath(filePath);
                if (!isValid) {
                    System.out.println("Введенный путь к файлу некорректен. Пожалуйста, введите правильный путь.");
                }
            }

            String finalFilePath = filePath;
            Thread deserializeThread = new Thread(() -> {
                try (FileInputStream fileIn = new FileInputStream(finalFilePath);
                     ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                    // Десериализация объекта Product
                    Product product = (Product) objectIn.readObject();

                    // Вывод содержимого полей объекта
                    System.out.println("Содержимое полей объекта Product:");
                    System.out.println("Code: " + product.getCode());
                    System.out.println("Name: " + product.getName());
                    System.out.println("Type: " + product.getType());
                    System.out.println("Is Discount: " + product.isDiscount());
                    System.out.println("Ingredients: " + product.getIngredients());
                    System.out.println("Price: " + product.getPrice());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });

            deserializeThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для проверки корректности пути к файлу
    private static boolean isValidPath(String path) {
        Pattern pattern = Pattern.compile("^(?:[a-zA-Z]\\:|\\\\)(\\\\[a-zA-Z0-9_.-]+)+$");
        Matcher matcher = pattern.matcher(path);
        return matcher.matches();
    }
}
