package common;

/**
 * @author lihailong
 * @since 2021/1/7 0007
 */
public class PiCalculator {

    // π = 4/1 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11...
    public static double calculatePi(int n) {
        final double four = 4.0;
        double d = 1.0;
        double operation = 1.0;
        double pi = 0.0;

        for (int i = 0; i < n; i++) {
            pi += (operation * (four / d));
            d = d + 2.0;
            operation *= -1.0;
        }
        return pi;
    }

    public static void main(String[] args) {
        System.out.println(PiCalculator.calculatePi(1000000000));
    }
}
