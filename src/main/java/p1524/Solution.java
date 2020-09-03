package p1524;

import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class Solution {

    public int numOfSubarrays(int[] arr) {

        int mod = 1000000007;
//        int[] sum = new int[arr.length + 1];


//        int ans = 0;
//        for (int i = 1; i <= arr.length; i++) {
//            sum[i] = sum[i - 1] + arr[i - 1];
//        }
//
//        for (int i = 0; i <= arr.length; i++) {
//            for (int j = i + 1; j <= arr.length; j++) {
//                if (((sum[j] - sum[i]) & 1) == 1) {
//                    ans = (ans + 1) % mod;
//                }
//            }
//        }
        int ans = 0;
        int odd = 0, even = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans = (ans + (sum % 2== 0 ? odd : even)) % mod;
            if (sum % 2 == 0) even++;
            else odd++;
        }

        return ans;

    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        List<String> lines = Files.readAllLines(Paths.get("D:\\spaces\\github.com\\leetcodesolver\\src\\main\\java\\p1524\\input.txt"));
        String[] split = lines.get(0).split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        long start = System.currentTimeMillis();
        int ans = s.numOfSubarrays(arr);
        long duration = System.currentTimeMillis() - start;
        System.out.println(ans);
        System.out.println("duration: " + duration);
        Assert.assertEquals(4, s.numOfSubarrays(new int[]{1, 3, 5}));
        Assert.assertEquals(0, s.numOfSubarrays(new int[]{2, 4, 6}));
        Assert.assertEquals(16, s.numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}));
        Assert.assertEquals(4, s.numOfSubarrays(new int[]{100, 100, 99, 99}));
        Assert.assertEquals(1, s.numOfSubarrays(new int[]{7}));
    }
}
