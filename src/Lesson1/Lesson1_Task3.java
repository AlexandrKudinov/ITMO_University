package Lesson1;
/*
Задание:
Заполните массив случайным числами и отсортируйте его.
Используйте сортировку пузырьком.

*/


import java.util.Scanner;

public class Lesson1_Task3 {
    public static void main(String[] args) {
        Scanner arraylength = new Scanner(System.in);
        System.out.println("enter the number of array:");
        int n = arraylength.nextInt();
        double[] array = new double[n];
        System.out.println("elements of array:");
        for (int i = 0; i < n; i++) {
            array[i] = Math.random();
            System.out.println(i + ":   " + array[i]);
        }
        System.out.println("sorted elements:20");
        for(int i=0;i<n-1;i++){
          for(int j = 0; j<n-1-i;j++){
              if (array[j] < array[j+1]) {
                  double tmp = array[j];
                  array[j]=array[j+1];
                  array[j+1]=tmp;
              }
          }
        }

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ":   " + array[i]);
        }
    }
}
// Created by Alexandr Kudinov on 16.10.19