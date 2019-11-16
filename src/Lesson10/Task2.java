package Lesson10;

public class Task2 {
    static int[][] array = new int[][]{{1, 12, 2, 3}, {2, 3, 4, 5}, {4, 5, 4, 6}, {3, 7, 6, 7}};
    static int[][] array1 = null;

    public static void main(String[] args) {
        System.out.println(cubeArray(array));
        cubeArray(array1);
    }

    public static boolean cubeArray(int[][] array) {
        if (array == null) {
            throw new NullPointerException("Массив не должен быть рабен нулю");
        }
        for (int i = 0; i < array.length; i++) {   //for (int[]inner : array)
            if (array[i].length != array.length)    //inner.length != array.length
                return false;
        }
        return true;
    }
}
