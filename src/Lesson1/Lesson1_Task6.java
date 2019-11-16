package Lesson1;/*

Задание:
Напишите программу, которая вычислит простые числа в пределах от 2 до 100.

*/

public class Lesson1_Task6 {
    public static void main(String[] args) {

        for (int i = 1; i<100;i++){
            boolean SimpleNumber =true;
            for(int j =2;j<i;j++) {
                if (i % j == 0) {
                    SimpleNumber = false;
                    break;
                }
            }
            if(SimpleNumber)
                System.out.println(i);
        }
// Created by Alexandr Kudinov on 17.10.19





    }

}
