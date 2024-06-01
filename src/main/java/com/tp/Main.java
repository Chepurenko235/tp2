package com.tp;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // Чтение чисел из файла
    private static List<Integer> readNumbersFromFile(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().map(Integer::parseInt).collect(Collectors.toList());
        }
    }

    // Поиск минимального числа
    public static int findMin(File file) throws IOException {
        List<Integer> numbers = readNumbersFromFile(file);
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Поиск максимального числа
    public static int findMax(File file) throws IOException {
        List<Integer> numbers = readNumbersFromFile(file);
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Сложение всех чисел
    public static int sum(File file) throws IOException {
        List<Integer> numbers = readNumbersFromFile(file);
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // Умножение всех чисел
    public static int multiply(File file) throws IOException {
        List<Integer> numbers = readNumbersFromFile(file);
        int product = 1;
        for (int number : numbers) {
            product *= number;
        }
        return product;
    }

    
}
