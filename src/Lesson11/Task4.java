package Lesson11;

import java.util.Arrays;

public class Task4 {
    public static void main(String [] args){

        String[]strings=new String[]{"SDFGSDG","ASDFASDFASF","ASD"};
        Shape[]shapes=new Shape[]{
                new Ball(33),
                new Pyramid(44,55),
                new Cylinder(33,55)
        };

        System.out.println( Maximum(strings));
        System.out.println(Maximum(shapes));


    }

    public static <T extends Comparable<? super T>>T Maximum (T[]array) {
        T max = array[0];
        for(T element: array){
            if(element.compareTo(max)>0){
                max=element;
            }
        }
        return max;
    }

}


