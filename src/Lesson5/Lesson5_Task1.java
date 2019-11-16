package Lesson5;

import java.util.Scanner;

public class Lesson5_Task1 {
    public static void main(String[] args) {
        Scanner arraylength = new Scanner(System.in);
        Scanner arrayElement = new Scanner(System.in);
        int n = arraylength.nextInt();
        String[]array=new String[n];
        for(int i = 0;i<n;i++){
            array[i]=arrayElement.nextLine();
        }
        System.out.println(StringLength.longestString(array));
    }
}
class StringLength {
    private String[] array;
    int n;
    public static String longestString(String[] array) {
        if(array.length == 0 ){
            return null;
        }

        String longest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > longest.length()) {
                longest = array[i];
            }
        }
        return longest;
    }
}
