package p1528;

class Solution {

    public String restoreString(String s, int[] indices) {
        char[] ch = s.toCharArray();
        char[] cp = new char[ch.length];
        for (int i = 0; i < indices.length; i++) {
            cp[indices[i]] = ch[i];
        }

        return new String(cp);
    }
}
