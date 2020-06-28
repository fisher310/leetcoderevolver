package p331;

/** */
class Solution {

    public boolean isValidSerialization(String preorder) {

        String[] nodes = preorder.split(",");
        int slots = 1;

        for (String n : nodes) {
            slots -= 1;

            if (slots < 0) {
                return false;
            }

            if (!"#".equals(n)) {
                slots += 2;
            }
        }
        return slots == 0;
    }
}
