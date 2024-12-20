package org.lab5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] names = {"книга", "ручка", "линейка", "пинал", "карандаш", "стерка", "корректор"};
        String[] colors = {"красный", "зеленый", "синий", "желтый", "черный", "белый", "оранжевый"}; // Массив возможных цветов
        Random random = new Random();
        ShopItem[] items = new ShopItem[100];

        // Генерация массива
        for (int i = 0; i < items.length; i++) {
            String name = names[random.nextInt(names.length)]; // Случайное имя
            int quantity = random.nextInt(10) + 1; // Случайное количество от 1 до 10
            int price = random.nextInt(100) + 1; // Случайная цена от 1 до 100, теперь целое число
            String color = colors[random.nextInt(colors.length)]; // Случайный цвет
            items[i] = new ShopItem(name, price, quantity, color);
        }

        // Сортировка массива по имени
        Arrays.sort(items, Comparator.comparing(ShopItem::getName));

        // Вывод объектов в консоль
        System.out.println("Товары, отсортированные по имени:");
        for (ShopItem item : items) {
            System.out.println(item);
        }

        // Подсчет количества одинаковых ShopItem
        Map<ShopItem, Integer> itemCount = new HashMap<>();
        for (ShopItem item : items) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }

        int totalDuplicates = 0;
        for (Map.Entry<ShopItem, Integer> entry : itemCount.entrySet()) {
            if (entry.getValue() > 1) {

                totalDuplicates += entry.getValue(); // Суммируем количество дубликатов
            }
        }

        System.out.println("\nКоличество одинаковых товаров: " + totalDuplicates);

        // Вывод количества уникальных товаров
        int uniqueCount = (int) itemCount.values().stream().filter(count -> count == 1).count();
        System.out.println("Количество уникальных товаров: " + uniqueCount);
    }
}

