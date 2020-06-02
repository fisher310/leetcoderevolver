package common;

class Prime {

    public int nthPrime(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        int nth = 3;
        int i = 5;
        while (nth <= n) {
            if (isPrime(i)) {
                if (++nth == n) {
                    return i;
                }
            }
            i++;
        }
        throw new IllegalArgumentException();
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Prime p = new Prime();
        System.out.println(p.nthPrime(10));
    }
}
