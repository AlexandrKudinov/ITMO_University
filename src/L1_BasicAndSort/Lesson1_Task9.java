package L1_BasicAndSort;
/*
Задание*:

Дан массив чисел. Найдите первое уникальное в это массиве число.
Например, для массива [1, 2, 3, 1, 2, 4] это число 3.
 */


public class Lesson1_Task9 {


    static int firstNonRepeating(int arr[], int n)
    {
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < n; j++)
                if (i != j && arr[i] == arr[j])
                    break;
            if (j == n)
                return arr[i];
        }

        return -1;
    }

    // Driver code
    public static void main(String[] args)
    {

        int arr[] = { 9, 4, 9, 6, 7, 4 };
        int n = arr.length;

        System.out.print(firstNonRepeating(arr, n));
    }
}






   /*
    public static void main(String[] args) {
        int[] array = {89, 2, 3, 4, 5, 6, 7, 7, 89, 2, 3, 4, 5, 6, 7, 89};
        int n = array.length;
        one:
        {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (array[i] == array[j] && i != j) {
                        break;
                    }
                    if (j == n - 1) {
                        System.out.println(array[i]);
                        break one;

                    }
                }

            }
        }

    }
}


    */