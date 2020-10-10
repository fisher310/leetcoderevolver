package offer40;

import java.util.Arrays;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quick_sort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    void quick_sort(int[] arr, int start, int end, int k) {
        if (start >= end) return;

        int p = partition(arr, start, end);
        if (p == k) return;

        if (p < k) quick_sort(arr, p + 1, end, k);

        if (p > k) quick_sort(arr, start, p - 1, k);
    }

    int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo + 1, j = hi;
        while (true) {
            while (i <= j && arr[i] < pivot) {
                i++;
            }
            while (j > i && arr[j] > pivot) {
                j--;
            }

            if (i > j) break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, lo, j);
        return j;
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.getLeastNumbers(new int[] {9, 2, 1, 11, 6, 4}, 2)));
        System.out.println("---------------------");
        System.out.println(
                Arrays.toString(s.getLeastNumbers(new int[] {9, 8, 7, 5, 3, 8, 5, 2}, 3)));
        System.out.println("---------------------");
        System.out.println(Arrays.toString(s.getLeastNumbers(new int[] {0, 0, 0, 2, 0, 5}, 0)));
    }
}
