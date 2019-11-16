package Lesson5;

import java.util.Scanner;

public class Lesson5_Task3 {
    public static void main(String[] args) {
        Scanner arraylength = new Scanner(System.in);
        Scanner arrayElement = new Scanner(System.in);
        int n = arraylength.nextInt();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = arrayElement.nextLine();
            //  System.out.println(array[i].charAt(array[i].length()));
        }


    }
}
/*
class ChangeText{
    private String[]array;
    public static String[] changetext(String[]array){
        for (int i = 0;i<array.length;i++){
            char[]arr = array[i].toCharArray();
            if(array[i].contains("бяка")){
                array[i].replace("бяка", "[вырезано]");
            }


        }

    }

}

 */


//задание 4  через indexOf в цикле while;
/*
int index = -1;
int counter = 0;
while((index = string.indexOf(subString, index+1)) != -1){

coubter;
}return counter;}

 */
 /* 6 задание
 public static void printSymbolsFrequensy (String text){
 text = text.toLowerCase();

 int charCount  = new int['я'-'a'+1];//последний минус первый в UNICODE

 for(int i=0;i<text.length();i++){
 if(text.charAt(i) >='a' && text.charAt(i) <='я');

   charsCounter[text.charAt(i)-'a']++;
 if(text.charAt(i) == 'йо'){
 charCounter[text.charAt(i)-'a']++;

 }

 }








 }



  */
