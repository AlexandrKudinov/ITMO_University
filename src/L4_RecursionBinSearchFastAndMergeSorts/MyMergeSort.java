package L4_RecursionBinSearchFastAndMergeSorts;

public class MyMergeSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 4, 3, 2, 3, 44, 55, 66, 77, 88, 66, 55, 44, 3333, 2, 3, 4, 3, 5, -111111111};

        for (int i : myMergeSort(a, a.length)) {
            System.out.println(i);
        }
    }

    public static int[] myMergeSort(int[] a, int n) {
        if (n < 2) {
            return a;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        myMergeSort(l, mid);
        myMergeSort(r, n - mid);

        union(a, l, r, mid, n - mid);
        return a;
    }

    public static void union(int[] a, int[] l, int[] r, int leftLength, int rightLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < leftLength) {
            a[k++] = l[i++];
        }
        while (j < rightLength) {
            a[k++] = r[j++];
        }
    }
}
