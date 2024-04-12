package org.example.create;

import java.io.*;
import java.util.ArrayList;
import org.example.service.Product;


public class CreateProduct {
    public static void main(String[] args) {
        // Создаем объект Product для сериализации
        Product product = new Product();
        product.setCode(12345);
        product.setName("Пример товара");
        product.setType("Пример типа товара");
        product.setDiscount(true);

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Ингредиент1");
        ingredients.add("Ингредиент2");
        product.setIngredients(ingredients);

        product.setPrice(50.0);

        try (FileOutputStream fileOut = new FileOutputStream("D:\\Help\\first.txt");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            // Сериализуем объект Product и записываем его в файл
            objectOut.writeObject(product);
            System.out.println("Объект Product успешно сериализован и сохранен в файл D:\\Help\\first.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
