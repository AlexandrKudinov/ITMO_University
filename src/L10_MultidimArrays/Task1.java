package L10_MultidimArrays;


public class Task1 extends Error {
    static int[][] array = new int[][]{{1, 12}, {2, 3}, {4, 5}, {3, 7}};
    static int[][] array1 = null;

    public static void main(String[] args) {
        System.out.println(find(array));
        System.out.println(new int[100][12]);
        System.out.println(find(null));
    }

    public static int find(int[][] array) {
        if (array == null || array.length ==0) {  //генерируем исклячения
            throw new IllegalArgumentException("Массив не должен быть равен нулю");
        }
        try {  // отлавливаем частный случай
            System.out.println(array[100][12]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("вышли за границу массива");
        } catch (Exception e) {
            System.out.println("тип значения не соответствует");
        }
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {             //(int[]inner: array){
            for (int j = 0; j < array[i].length; j++) {      //(int item: inner){
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

}
