package common;

class APlusB {

    public int aplusb(int a, int b) {

        int c = a ^ b;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        int d = (a & b) >> 1;
        while (d != 0) {
            System.out.printf("%05s\n", (c));
            System.out.printf("%5\n", Integer.toBinaryString(d));
            System.out.println("---------------------");
            c = c ^ d;
            d = (d & c) >> 1;
        }
        return c;
    }

    public static void main(String[] args) {
        APlusB a = new APlusB();
        System.out.println(a.aplusb(3, 6));
    }
}
