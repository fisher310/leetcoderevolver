package p762;

public class Solution {
	public int countPrimeSetBits(int left, int right) {
		
		int ans = 0;
		for (int i = left; i <= right; i++) {
			if (isPrime(countBits(i))) {
				// System.out.println(	i + ": " + Integer.toBinaryString(i) + "; " + countBits(i));
				ans++;
			}
		}

		return ans;
	}

	boolean isPrime(int n) {
		if (n == 1) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	int countBits(int n) {
		int res = 0;
		while (n != 0) {
			res += 1;
			n = n & (n - 1);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.countBits(3));
		System.out.println(s.countBits(117));
		System.out.println(s.countPrimeSetBits(6, 10));
		System.out.println(s.countPrimeSetBits(10, 15));
	}
}
