package p853;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        if (null == position || position.length == 0) return 0;

        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
            cars[i].time = (target - cars[i].pos) / (double) cars[i].speed;
        }

        Arrays.sort(cars, Comparator.comparingInt(o -> o.pos));

        int ans = 0;
        for (int i = cars.length - 1; i > 0; i--) {
            if (cars[i].time < cars[i - 1].time) {
                ans++;
            } else {
                cars[i - 1].time = cars[i].time;
            }
        }

        ans += (cars[0].time == 0 ? 0 : 1);
        return ans;
    }

    private static class Car {
        int pos;
        int speed;
        double time;

        Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(3, s.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
    }
}
