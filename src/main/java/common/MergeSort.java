package common;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int m = l + (r - l) / 2;

        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, m + 1, r);
    }

    private void merge(int[] arr, int l, int m, int n, int r) {
        int[] buf = new int[r - l + 1];

        int i = l, j = n, k = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                buf[k++] = arr[i++];
            } else {
                buf[k++] = arr[j++];
            }
        }

        while (i <= m) {
            buf[k++] = arr[i++];
        }
        while (j <= r) {
            buf[k++] = arr[j++];
        }

        System.arraycopy(buf, 0, arr, l, buf.length);
    }


    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.sort(new int[]{3, 4, 2, 5, 9, 9, 2, 7});
    }
}
