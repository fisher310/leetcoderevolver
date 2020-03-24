package p14;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * <p>如果不存在公共前缀，返回空字符串 ""。 ["flower","flow","flight"] -> "fl" ["dog","racecar","car"] -> ""
 */
class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String s0 = strs[0];

        Node root = null;
        int len = Integer.MAX_VALUE;
        outer:
        for (String s : strs) {
            if (s == null || s.length() == 0) {
                return "";
            }
            if (root == null) {
                root = stringToNode(s);
                continue;
            }
            Node node = root;
            int l = 0;
            for (char c : s.toCharArray()) {
                if (node != null && node.value == c) {
                    l++;
                    node = node.next;
                    if (l > len) {
                        continue outer;
                    }
                } else {
                    break;
                }
            }
            if (l < len) {
                len = l;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (len > 0 && root != null) {
            sb.append(root.value);
            root = root.next;
            len--;
        }

        return sb.toString();
    }

    private Node stringToNode(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Node root = null;
        Node node = null;
        for (char c : s.toCharArray()) {
            if (node == null) {
                node = new Node(c);
                root = node;

            } else {
                node.next = new Node(c);
                node = node.next;
            }
        }
        return root;
    }

    static class Node {
        Character value;
        Node next;

        Node(Character c) {
            this.value = c;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
