package org.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Task9 {
    private static final int GAME_DURATION = 60; // Время игры в секундах

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        // Получаем слова из файла
        List<String> words = getWords("/Users/anastasiaholodova/Documents/Java/words.txt");
        Collections.shuffle(words); // Перемешиваем список слов

        int correctCount = 0; // Счетчик правильных слов
        int totalWords = 0; // Общее количество предложенных слов
        StringBuilder typedWords = new StringBuilder(); // Для подсчета введенных символов

        System.out.println("Введите слова, которые вам будут предложены. У вас 1 минута!");

        long startTime = System.currentTimeMillis(); // Запоминаем начальное время

        // Цикл игры
        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime; // Прошедшее время
            if (elapsedTime > GAME_DURATION * 1000) { // Если прошло больше минуты
                break;
            }

            // Предлагаем случайное слово
            String word = words.get(totalWords % words.size()); // Берем слово по индексу
            totalWords++;
            System.out.println("Слово: " + word);

            // Чтение введенного слова от пользователя
            Scanner inputScanner = new Scanner(System.in);
            String userInput = inputScanner.nextLine();
            typedWords.append(userInput); // Добавляем введенное слово для подсчета символов

            // Сравнение введенного слова с предложенным
            if (userInput.equals(word)) {
                correctCount++;
            }
        }

        // Итоговые результаты
        long totalTime = System.currentTimeMillis() - startTime;
        int totalCharacters = typedWords.length();
        double typingSpeed = (double) totalCharacters / (totalTime / 1000.0); // символов в секунду

        System.out.println("\nВремя вышло!");
        System.out.println("Общее количество предложенных слов: " + totalWords);
        System.out.println("Количество правильных слов: " + correctCount);
        System.out.printf("Количество введенных символов: %d, Скорость напечатанных символов: %.2f скор./с\n",
                totalCharacters, typingSpeed);
    }

    // Возвращает список слов из файла
    public static List<String> getWords(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        List<String> words = new ArrayList<>();
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine());
        }
        scanner.close();
        return words;
    }
}
