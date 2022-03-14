package p744;

import org.junit.Assert;

public class Solution {

	public char nextGreatestLetter(char[] letters, char target) {
		int n = letters.length;
		if (letters[n-1] < target) {
			return letters[0];
		}

		for (int i = 0; i < n; i++) {
			if (letters[i] > target) {
				return letters[i];
			}
		}
			
		return letters[0];
	}

	public static void main(String[] args) {
		System.out.println("name");
		Solution s = new Solution();
		Assert.assertEquals('a', s.nextGreatestLetter(new char[]{'a', 'b', 'c'}, 'z'));
	}
}
