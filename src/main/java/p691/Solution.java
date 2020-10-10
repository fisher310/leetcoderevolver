package p691;

/**
 * 贴纸拼词
 */
class Solution {

    public int minStickers(String[] stickers, String target) {
        int num = 0;
        int[] t = new int[26];
        for (char c : target.toCharArray()) {
            t[c-'a'] ++;
            num++;
        }

        int[][] dic = new int[stickers.length][26];
        int[] allDic = new int[26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                if (t[c - 'a'] > 0) {
                    dic[i][c - 'a']++;
                    allDic[c-'a']++;
                }
            }
        }
        for (int k = 0; k < 26; k++) {
            if (t[k] > allDic[k]) return -1;
        }




        return 0;
    }
}
