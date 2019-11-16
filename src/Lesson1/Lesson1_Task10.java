package Lesson1;
/*

Задание*:
Дан массив и число K. Найдите первые K самых часто встречающихся
элементов.

*/


import java.util.Arrays;

public class Lesson1_Task10 {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 1, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 1, 1, 1, 1, 5, 5, 517,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
        int mostCommon = 2;//количество самых часто встречающихся
        int[] array1 = new int[array.length]; //массив для хранения числа повторений каждого элемента


        //ищем повторяющиеся элементы
        for (int i = 0; i < array.length; i++) {
            int repeat = 1;// счетчик повторений
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) { //если нашли повторение,удаляем его из массива, и увеличивает на 1 счетчик повторений
                    for (int k = j + 1; k < array.length; k++) {
                        array[k - 1] = array[k];
                    }
                    array = Arrays.copyOf(array, array.length - 1);//уменьшаем длину массива
                    j--;
                    repeat++;
                }
            }
            array1[i] = repeat;// сохраняем количество повторений первого элемента в массив
        }
        array1 = Arrays.copyOf(array1, array.length);




        //находим в массиве для количества повторений первый максимальный элемент
        for (int i =0;i<mostCommon;i++){
            int indexMax=0;
            for(int j =i+1;j<array1.length;j++){
               if(array1[j]>array1[indexMax]){
                   indexMax=j;
               }
            }
            System.out.println(array[indexMax]);// выводим соответствующий ему элемент базового массива

            //удаляем элемент с наибольшем числом повторений, и их количество из массивов, и переопределяем их
            for (int k = indexMax + 1; k < array.length; k++) {
                array1[k - 1] = array1[k];
                array[k-1] = array[k];
            }
            array1 = Arrays.copyOf(array1, array1.length - 1);
            array = Arrays.copyOf(array, array.length - 1);
        }

    }
}
