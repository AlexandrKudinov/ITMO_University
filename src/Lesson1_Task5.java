/*
Задание:
    Заполните массив случайным числами и отсортируйте его.
    Используйте сортировку вставками.
*/


import java.util.Scanner;

public class Lesson1_Task5 {
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
        for(int i =1;i<array.length;i++){
            double temp=array[i];
            int j =i-1;
            while (array[j]<temp && j>=0){

                array[j+1]=array[j];
                j--;
              }
            array[j+1]=temp;
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(i + ":   " + array[i]);
        }

        }


    }
// Created by Alexandr Kudinov on 17.10.19