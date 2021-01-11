package p1201;

import org.junit.Assert;

class Solution {
    int a, b, c;
    long lcmAB, lcmAC, lcmBC, lcmABC;

    public int nthUglyNumber(int n, int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.lcmAB = lcm(a, b);
        this.lcmBC = lcm(b, c);
        this.lcmAC = lcm(a, c);
        this.lcmABC = lcm(this.lcmAB, this.c);
        //        System.out.println(this.lcmAB + ", " + this.lcmBC + "," + this.lcmAC +", " +
        // this.lcmABC);

        long l = Math.min(a, Math.min(b, c)), r = l * n;

        while (l < r) {
            long mid = l + (r - l) / 2;
            long m = check(mid, n);
            //            System.out.println(l + ", " + r + "," + mid + "-->" + m);
            if (m < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        //        System.out.println(l + ", " + r);
        return (int) l;
    }

    private long check(long m, int n) {
        long na = m / a;
        long nb = m / b;
        long nc = m / c;
        return na
                + nb
                + nc
                - (m / this.lcmAB)
                - (m / this.lcmBC)
                - (m / this.lcmAC)
                + (m / this.lcmABC);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        // 2
        // 11
        // 13
        Assert.assertEquals(6, s.nthUglyNumber(4, 2, 3, 4));
        Assert.assertEquals(10, s.nthUglyNumber(5, 2, 11, 13));
        Assert.assertEquals(1999999984, s.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }
}
