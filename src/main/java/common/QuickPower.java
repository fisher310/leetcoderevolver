package common;

/** 快速幂模板代码 */
public class QuickPower {

    public int power(int a, int n, int m) {
        if (n == 0) return 1;

        long res = power(a, n / 2, m);
        res = res * res % m;
        if ((n & 1) == 1) res = (res * a % m);

        return (int) res;
    }
}
