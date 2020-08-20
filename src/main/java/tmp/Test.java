package tmp;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.test1();
        test.test2();
    }

    public void test1() {
        int i = 8;
        i = i++;

        System.out.println(i);
    }

    public void test2() {
        int i = 8;
        i = ++i;

        System.out.println(i);
    }
}
