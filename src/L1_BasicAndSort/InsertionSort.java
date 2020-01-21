package L1_BasicAndSort;

/*
Задание:
    Заполните массив случайным числами и отсортируйте его.
    Используйте сортировку вставками.
*/

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 5, 6, 7, 4, 3, 44, 55, 66, 7, 3, 2, 3, 4, 44, 6666677};
        inSo(array);
        for (int i : array) {
            System.out.println(i);
        }
    }


    public static int[] inSo(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int tmp = array[i];
            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
        return array;
    }


}