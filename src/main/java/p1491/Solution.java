package p1491;

class Solution {
    public double average(int[] salary) {
        int sum = 0;
        int max = salary[0], min = salary[0];

        for (int n : salary) {
            sum += n;
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        return (sum - max - min) / (double)(salary.length - 2);

    }
}
