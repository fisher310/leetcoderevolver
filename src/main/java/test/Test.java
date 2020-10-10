package test;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }

    public void test() {
        int l;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            l = fib(50);
        }
        long end = System.currentTimeMillis();
        System.out.println("duration: " + (end - start));
    }

    public int fib(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
