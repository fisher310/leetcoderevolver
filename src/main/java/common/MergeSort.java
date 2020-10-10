package common;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) >> 1;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, mid + 1, r);
    }

    private void merge(int[] arr, int l1, int r1, int l2, int r2) {
        int[] temp = new int[r2 - l1 + 1];
        int index = 0;
        int start = l1;
        while (l1 <= r1 && l2 <= r2) {
            if (arr[l1] <= arr[l2]) {
                temp[index++] = arr[l1++];
            } else {
                temp[index++] = arr[l2++];
            }
        }

        while (l1 <= r1) {
            temp[index++] = arr[l1++];
        }
        while (l2 <= r2) {
            temp[index++] = arr[l2++];
        }

        System.arraycopy(temp, 0, arr, start, temp.length);
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.sort(new int[] {3, 4, 2, 5, 9, 9, 2, 7});
    }
}
