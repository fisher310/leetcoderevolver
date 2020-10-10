package common;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int p = partition(arr, start, end);
        quickSort(arr, start, p - 1);
        quickSort(arr, p + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int p = start;
        for (int i =start; i <= end; i++) {
            if (arr[i] < pivot) {
                swap(arr, i , p);
                p++;
            }
        }

        swap(arr, p, end);

        return p;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = new int[] {5, 3, 2, 4, 1, 5, 1};

        qs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
