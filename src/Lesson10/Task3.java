package Lesson10;

public class Task3 {
    static int[][] array = new int[][]{{1, 12}, {2, 33}, {4, 5}, {3, 777}};
    static int[][] array1 = null;

    public static void main(String[] args) {
        System.out.println(maxLine(array));
    }

    public static int maxLine(int[][] array) {
        if (array == null) {
            throw new NullPointerException("пустое значение");
        }
        int maxLineValue = 0;
        int maxLine = 0;
        for (int i = 0; i < array[0].length; i++) {
            maxLineValue += array[0][i];
        }
        for (int i = 0; i < array.length; i++) {
            int LineValue = 0;
            for (int j = 0; j < array[i].length; j++) {
                LineValue += array[i][j];
                if (maxLineValue < LineValue) {
                    maxLineValue = LineValue;
                    maxLine = i;
                }
            }
        }
        return maxLine;
    }
}
