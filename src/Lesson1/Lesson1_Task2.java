package Lesson1;
/*

Задание:
Найти алгебраическую сумму для выражения: 1^k + 2^k + 3^k + … + N^k .
N и степень k вводит пользователь.

 */

import java.util.Scanner;

public class Lesson1_Task2 {
    public static void main(String args[]) {
        Scanner parameters = new Scanner(System.in);
        System.out.println("enter n");
        int n = parameters.nextInt();
        System.out.println("enter k");
        int k = parameters.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int degree = i;
            for (int j = 0; j < k - 1; j++) {
                degree *= degree;
            }
            sum += degree;
        }
        System.out.println("sum= " + sum);
    }
}
// Created by Alexandr Kudinov on 16.10.19