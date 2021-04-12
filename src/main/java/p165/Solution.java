package p165;

/**
 * @author lihailong
 * @since 2021/04/12 11:28:57
 */
class Solution {

    public int compareVersion(String version1, String version2) {

        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int n1 = arr1.length, n2 = arr2.length;
        int max = Math.max(n1, n2);
        for (int i = 0; i < max; i++) {
            int i1 = i < n1 ? Integer.parseInt(arr1[i]) : 0;
            int i2 = i < n2 ? Integer.parseInt(arr2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }

        return 0;
    }
}
