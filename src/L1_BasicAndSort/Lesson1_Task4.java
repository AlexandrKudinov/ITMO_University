package L1_BasicAndSort;/*
Задание:
Заполните массив случайным числами и отсортируйте его.
Используйте сортировку выбором.

*/


import java.util.Scanner;

public class Lesson1_Task4 {
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

        for(int i=0;i<array.length-1;i++){
            double max = array[i];
            int index=i;
            for(int j=i+1;j<array.length;j++){
                if (array[j] > max) {
                    max=array[j];
                    index=j;
                }
            }
            double temp = array[i];
            array[i]=max;
            array[index]=temp;
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(i + ":   " + array[i]);
        }
    }
}
// Created by Alexandr Kudinov on 16.10.19




