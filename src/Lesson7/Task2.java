package Lesson7;

import java.util.Scanner;

/*

Используя Stringbuilder, читайте слова с консоли и затем склейте их в одну строку
через запятую.

*/
public class Task2 {
    public static void main(String[] args) {
        Scanner arraylength = new Scanner(System.in);
        Scanner arrayElement = new Scanner(System.in);
        int n = arraylength.nextInt();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = arrayElement.nextLine();
        }
        System.out.println(SingleString(array));
    }


    public static String SingleString(String[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i < array.length - 1) {
                stringBuilder.append(" , ");
            }
        }
        return stringBuilder.toString();
    }




/*  альтернативное решение с удалением последне запятой
    public static String SingleString (String[]array){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<array.length;i++){
            stringBuilder.append(array[i]+" , ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1)
                     .deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

 */


}

