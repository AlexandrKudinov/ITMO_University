package L5_Strings;
/*

Написать метод, который проверяет является ли слово палиндромом.

*/
import java.util.Scanner;

public class Lesson5_Task2 {
    public static void main(String[] args) {
            Scanner arraylength = new Scanner(System.in);
            Scanner arrayElement = new Scanner(System.in);
            int n = arraylength.nextInt();
            String[] array = new String[n];



            for (int i = 0; i < n; i++) {
                array[i] = arrayElement.nextLine();
            }

           // Polindrom.polindrom(array);
       NewPolindrom.isPalindrome(array);

        }
    }

class Polindrom {
    private String[] array;

    public static void polindrom(String[] array) {
        for (int i = 0; i < array.length; i++) {

            array[i] = array[i].toLowerCase();//important
            one:
            {
                for (int j = 0; j <= array[i].length() / 2; j++) {
                    if (array[i].charAt(j) == array[i].charAt(array[i].length() - 1 - j)) {
                    } else {
                        System.out.println(array[i] + "   " + false);
                        break one;
                    }
                }
                System.out.println(array[i] + "   " + true);
            }
        }
    }
}

/*
    Перепишите метод, проверяющий слово на палиндромность с помощью
    Stringbuilder. В таком методе должно быть 1-3 строки.

 */


class NewPolindrom {
    public static void isPalindrome(String [] array) {
        for(int i =0; i<array.length; i++) {
            String reversed = new StringBuilder(array[i]).reverse().toString();
            if(reversed.equalsIgnoreCase(array[i])){
                System.out.println(array[i] +" is a polindrom");
            }else {
                System.out.println(array[i]+" not a polindrom");
            }
        }
    }


}