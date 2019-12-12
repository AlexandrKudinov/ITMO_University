package L4_RecursionBinSearchFastAndMergeSorts;

/*
Задание:
Написать метод, который проверяет, входит ли в сортированный массив заданный эдемент или нет.
Используйте перебор и двоичный поиск для решения данной задачи.
Сравните время выполнения обоих решений для больших массивов (100000 элементов).
*/


import java.util.Scanner;

public class BinSearch {
    public static void main(String[] args) {

        Scanner arraylength = new Scanner(System.in);

// Fill the array with random integer elements

        System.out.println("Enter an array length:");
        int n = arraylength.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            // array[i] = i;
            array[i] = (int) (Math.random() * 1000000);
        }
        // Call a sorting by choose recursion method

        sort(array);

        System.out.println("Sorted elements of array:");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%4d  :  %14d \n", i, array[i]);
        }

        // Enter the item, which need to search for

        System.out.println("Enter the item, which need to search for: ");
        int k = arraylength.nextInt();
        System.out.println(find(array, k, 0, n));


        System.out.println("Enter the item, which need to search for: ");
        int m = arraylength.nextInt();                                     // Output the entered element index by calling a binary search method
        System.out.println(find(array, m, 0, n));

        System.out.println("Enter the item, which need to search for: ");
        int l = arraylength.nextInt();
        System.out.println(find(array, l, 0, n));
    }

//  sorting elements of array by choice

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

// binary search of element index

    public static int find(int[] array, int value, int start, int end) {

        if (end - start == 1 && (array[end] != value && array[start] != value)) {
            return -1;
        }
        int mid = (start + end) / 2;
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