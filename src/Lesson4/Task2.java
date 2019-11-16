package Lesson4;

/*
Задание:
реализовать быструю сортировку
*/

import java.util.Arrays;


public class Task2 {
    public static void main(String[] args) {

        double[] array = {3, 7, 8, 5, 2, 1, 9, 5, 4};

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
        }

        FastSort.quickSort(array, 0, array.length - 1);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
        }
    }
}


class FastSort {

    private double[] array;

    public FastSort(double[] array) {
        this.array = array;
    }

    public static void quickSort(double[] array, int low, int high) {

        if (array.length == 0) {
            return;         //завершить выполнение если длина массива равна 0
        }
        if (low >= high) {
            return;         //завершить выполнение если уже нечего делить
        }


        int middle = low + (high - low) / 2;
        double base = array[middle];        // выбрать опорный элемент

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {

            while (array[i] < base) {
                i++;
            }

            while (array[j] > base) {
                j--;
            }

            if (i <= j) {//меняем местами
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                ++i;
                --j;
            }
        }


        if (low < j) {
            quickSort(array, low, j);
        }

        if (high > i) {
            quickSort(array, i, high);
        }
    }

}


