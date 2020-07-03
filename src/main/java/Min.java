import java.util.LinkedList;

class Min {

    public int[] getMin(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        LinkedList<Integer> stack = new LinkedList<>();

        int [] ans = new int[nums.length];
        ans[0] = -1;
        stack.push(ans[0]);
        for (int i = 1; i < nums.length; i++) {
//            if (!stack.isEmpty() && stack.peek() < )

        }

        return null;

    }

    public static void main(String[] args) {
        int n = 7;
//        int n = 8;
        System.out.println(n & (-n));
        int x = 0;
        while (n != 0) {
            n = n - (n & (-n));
            x += 1;
        }
        System.out.println(x);

        n = 7;
        while (n > 0) {
            System.out.printf("[%d, %d]\n", n - (n & (-n)) + 1, n);
            n = n - (n & (-n));
        }
    }
}
