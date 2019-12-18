package L4_RecursionBinSearchFastAndMergeSorts;

import java.lang.reflect.Array;

public class MyMergeSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 4, 3, 2, 3, 44, 55, 66, 77, 88, 66, 55, 44, 3333, 2, 3, 4, 3, 5, -111111111};

        for (int i : mergeSort(a, a.length)) {
            System.out.println(i);
        }
    }



    public static int[] mergeSort(int[] array, int arrayLength) {
        if (arrayLength < 2) {
            return array;
        }
        int middle = arrayLength / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[arrayLength - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int i = middle; i < arrayLength; i++) {
            rightArray[i - middle] = array[i];
        }
        mergeSort(leftArray, middle);
        mergeSort(rightArray, arrayLength - middle);
        mergeUnion(array, leftArray, rightArray, middle, arrayLength - middle);
        return array;
    }


    public  static void mergeUnion(int[] array,
                           int[] leftArray,
                           int[] rightArray,
                           int leftLength,
                           int rightLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] < rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftLength) {
            array[k++] = leftArray[i++];
        }
        while (j < rightLength) {
            array[k++] = rightArray[j++];
        }
    }
}