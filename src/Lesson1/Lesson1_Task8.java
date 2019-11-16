package Lesson1;
/*

Задание*:
Дан массив чисел и число. Удалите все вхождения числа в массив (пропусков быть не должно).

*/

public class Lesson1_Task8 {
    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,3,3,3,3,3,3,3,3,4,5,6};
        int n = array.length;
        int k = 3;
        for(int i = 0;i<n;i++){
            if(array[i]==k){
                for(int j=i+1;j<n;j++){
                    array[j-1]=array[j];
                }
                n--;
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + ":   " + array[i]);
        }

    }
}
// Created by Alexandr Kudinov on 17.10.19




/*
Пример решения на занятии:
class Main{

    public static void main(String[] args) {
        int test_array[] = {0,1,2,2,3,0,4,2};

           // Arrays.toString:
           // см. https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html

        System.out.println(Arrays.toString(removeElement(test_array, 3)));
    }

    public static int[] removeElement(int[] nums, int val) {
        int offset = 0;

        for(int i = 0; i< nums.length; i++){
            if(nums[i] == val){
                offset++;
            } else{
                nums[i - offset] = nums[i];
            }
        }

        // Arrays.copyOf копирует значение из массива nums в новый массив
        // с длинной nums.length - offset
        return Arrays.copyOf(nums, nums.length - offset);
    }

}
*/







