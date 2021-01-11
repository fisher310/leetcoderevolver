package p860;

/**
 * @author lihailong
 * @since 2020/12/10 0010
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five <= 0) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            } else {
                if (ten > 0) {
                    if (five > 0) {
                        ten--;
                        five--;
                    } else {
                        return false;
                    }
                } else {
                    if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
