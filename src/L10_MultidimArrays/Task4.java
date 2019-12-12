package L10_MultidimArrays;

public class Task4 extends RuntimeException {
    static int[][] array = new int[][]{{1, 12, 4, 6, 4}, {-2, -3, 6, 7}, {4, 5, 8, 7}, {-3, 7, 5, -5}};
    static int[][] array1 = null;

    public static void main(String[] args) {
        //System.out.println(find(array));
        find(array1);
        // System.out.println(new Shape[100][22]);
    }

    public static int find(int[][] array) {
        if (!cubeArray(array)) {
            throw new UnsupportedOperationException("МАТРИЦА ДОЛЖНА БЫТЬ КВАДРАТНОЙ");
        }
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][i] > 0) {
                max++;
            }
        }
        return max;
    }

    public static boolean cubeArray(int[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Массив не должен быть равен нулю");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != array.length)
                return false;
        }
        return true;
    }

}