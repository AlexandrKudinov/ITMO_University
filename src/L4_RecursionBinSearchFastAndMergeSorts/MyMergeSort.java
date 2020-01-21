package L4_RecursionBinSearchFastAndMergeSorts;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyMergeSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 4, 3, 2, 3, 44, 55, 66, 77, 88, 66, 55, 44, 3333, 2, 3, 4, 3, 5, -111111111};

        for (int i : MS.sort(a, a.length)) {
            System.out.println(i);
        }
    }

}



class MS {
    public static int[] sort(int[] array, int length) {
        if (length < 2) {
            return array;
        }
        int mid = length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = array[i];
        }

        for (int i = mid; i < length; i++) {
            rightArr[i - mid] = array[i];
        }
        sort(leftArr, mid);
        sort(rightArr, length - mid);
        union(array, leftArr, rightArr, mid, length - mid);
        return array;
    }

    private static void union(int[] array, int[] leftArr, int[] rightArr, int leftLength, int rightLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (leftArr[i] < rightArr[j]) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }
        while (i < leftLength) {
            array[k++] = leftArr[i++];
        }
        while (j < rightLength) {
            array[k++] = rightArr[j++];
        }
    }

}
