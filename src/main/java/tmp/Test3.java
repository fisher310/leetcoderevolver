package tmp;

class Test3 {

    public int maxDiff(int[] arr) {
        int ans = 0;
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
            } else {
                ans = Math.max(ans, max - arr[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        int ans = t.maxDiff(new int[] {662, 660, 449, 456, 890, 340, 190, 570, 789});
        System.out.println(ans);
        ans = t.maxDiff(new int[] {662, 660, 449, 160, 890, 340, 190, 570, 789});
        System.out.println(ans);
    }
}
