package tmp;

class Test3 {

    public int maxDiff(int[] arr) {
        int l = 0, r = arr.length-1;
        int ans = 0;
        while (l < r) {
            int diff = arr[r] - arr[l];
            if (diff > ans) {
                ans = diff;
                System.out.printf("arr[%d] - arr[%d] = %d\n", r, l, diff);
            }

            if (arr[r - 1] > arr[r]) {
                r--;
            } else {
                l++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        int ans = t.maxDiff(new int[]{662,660,449,456,890,340,190,570,789});
        System.out.println(ans);
    }
}
