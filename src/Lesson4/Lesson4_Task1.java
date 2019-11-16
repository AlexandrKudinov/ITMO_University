package Lesson4;/*
Задание:
Написать метод, который проверяет, входит ли в сортированный массив заданный эдемент или нет.
Используйте перебор и двоичный поиск для решения данной задачи.
Сравните время выполнения обоих решений для больших массивов(100000 элементов).
 */


import java.util.Scanner;

public class Lesson4_Task1 {
    public static void main(String[] args) {

        Scanner arraylength = new Scanner(System.in);

// Fill the array with random integer elements

        System.out.println("Enter an array length:");
        int n = arraylength.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 1000);
        }

// Call a sorting by choise recursion method

        sort(array, 0);

// Output the sorted elements of array

        System.out.println("Sorted elements of array:");
        for (int i = 0; i < n; i++) {
            System.out.printf("%4d  :  %14d \n", i, array[i]);
        }

// Enter the item, which need to search for

        System.out.println("Enter the item, which need to search for: ");
        int k = arraylength.nextInt();
        for(int i=0;i<array.length;i++){
            if(k==array[i]){
                System.out.println(i);
            }
        }

// Output the entered element index by calling a binary search method




        System.out.println("Index of item is: " + find(array, k, 0, n));

    }

//  sorting elements of array by choice

    public static void sort(int[] array, int start) {
        if (start == array.length - 1) return;
        int indexMax = start;
        for (int j = start + 1; j < array.length; j++) {
            if (array[j] > array[indexMax]) {
                indexMax = j;
            }
        }
        int tmp = array[start];
        array[start] = array[indexMax];
        array[indexMax] = tmp;
        sort(array, start + 1);
    }

// binary search of element index

    public static int find(int[] array, int value, int start, int end) {

        int mid = (start + end) / 2;

        if (end - start == 1 && (array[end] != value && array[start]!=value))
            return -1;

        if (value == array[mid]) {
            return mid;
        } else if (value < array[mid]) {
            return find(array, value, start, mid);
        } else {
            return find(array, value, mid, end);
        }
    }
}



































/*
    int half = (end+start)/2;


        if (value == arr[half]) {
                return half;
                }

                if(end-start==1)
                return -1;

                else if (value > arr[half]) {
                return find(arr,value,half,end);
                }
                else {
                return find(arr,value,start,half);
                }

 */