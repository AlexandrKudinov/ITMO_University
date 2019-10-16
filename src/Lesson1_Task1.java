
/*
Задание:
Заполните массив случайным числами и выведете максимальное, минимальное и
среднее значение.
Для генерации случайного числа используйте метод Math.random(), который
возвращает значение в промежутке [0, 1].
 */


import java.util.Scanner;

public class Lesson1_Task1 {
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

        double max = array[0];
        double min = array[0];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            if (max < array[i])
                max = array[i];

            if (min > array[i])
                min = array[i];

            sum += array[i] / array.length;
        }
        System.out.println("max= " + max + " min= " + min + " average= " + sum);
    }
}
