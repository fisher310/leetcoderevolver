package p748;
import java.util.Arrays;

class Solution {
	public String shortestCompletingWord(String licensePlate, String[] words) {

		int[] arr = new int[26];
		count(licensePlate, arr);
		String res = null;
		int[] tmp = new int[26];
		for (String word : words) {
			if (isCompletingWord(word, arr, tmp)) {
				if (res == null) {
					res = word;
				} else if (word.length() < res.length()) {
					res = word;
				}
			}
		}
		
		return res;
	}

	boolean isCompletingWord(String word, int[] arr, int[] tmp) {
		count(word, tmp);
		for (int i = 0; i < 26; i++) {
			if (tmp[i] < arr[i]) {
				return false;
			}
		}
		return true;
	}

	void count(String word, int[] arr) {
		Arrays.fill(arr, 0);
		for (int i = 0; i < word.length(); i++ ) {
			char c = word.charAt(i);
			if (c >= 'a' && c <='z') {
				arr[c - 'a']++;
			} else if (c >= 'A' && c <= 'Z') {
				arr[c - 'A']++;
			}
		}
	}
}
