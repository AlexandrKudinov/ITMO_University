package L1_BasicAndSort;
/*
Задание:
Заполните массив случайным числами и отсортируйте его.
Используйте сортировку пузырьком.
*/

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 2, 1, 3, 4, 5, 6, 7, 8, 4, 3, 5, 6, 7, 11, 22, 33, 22, 11, -11};
        bubbleSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}