package L4_RecursionBinSearchFastAndMergeSorts;

/*
Задание:
реализовать быструю сортировку
*/


public class FastSort {
    public static void main(String[] args) {

        int[] array = {3, 7, 8, 5, 2, 1, 9, 5, 4};

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
        }

        FSo.sort(array, 0, array.length - 1);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
        }
    }
}


class FSo {
    public static void sort(int[] array, int start, int stop) {
        if (array.length == 0) {
            return;
        }
        int tmp;
        int mid = start + (stop - start) / 2;
        int madA = array[mid];
        int i = start;
        int j = stop;


        while (i <= j) {
            while (array[i] < madA) {
                i++;
            }
            while (array[j] > madA) {
                j--;
            }

            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }

        if(i<stop){
            sort(array,i,stop);
        }
        if(j>start){
            sort(array,start,j);
        }
    }


}

