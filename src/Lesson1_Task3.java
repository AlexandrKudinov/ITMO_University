
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

        for(int i=0;i<n-1;i++){
            if(array[i]>array[i+1]){
                double temp = array[i];
                array[i]=array[i+1];
                array[i+1]=temp;
            }
            if(i==n-2){
                i=-1;
                n=n-1;
            }
        }

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ":   " + array[i]);
        }
    }
}
