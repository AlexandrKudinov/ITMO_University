package L2_VectorAndArrayList;

import java.util.Arrays;

public class Lesson2_Task2 {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(6));
        System.out.println(list.get(7));


        System.out.println();
        list.remove(2);


        System.out.println(list.size());
        System.out.println(list.get(2));


        list.remove(2);
        System.out.println(list.size());
        System.out.println(list.get(2));

        list.remove(2);
        System.out.println(list.size());
        System.out.println(list.get(2));

    }
}

class MyArrayList {
    int size = 0;
    double[] array = new double[10];

    void add(double number) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = number;
        size++;
    }

    double get(int n) {
        return array[n];
    }

    int size() {
        return array.length;
    }


    void remove(int i) {
        for (int j = i; j < size - 1; j++) {
            array[j] = array[j + 1];
        }
        array = Arrays.copyOf(array, array.length - 1);
        size--;
    }


}

