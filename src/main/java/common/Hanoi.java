package common;

import java.util.LinkedList;

/**
 * @author lihailong
 * @since 2021/1/18 0018
 */
public class Hanoi {

    private final int numDisc;

    private final LinkedList<Integer> towerA = new LinkedList<>();
    private final LinkedList<Integer> towerB = new LinkedList<>();
    private final LinkedList<Integer> towerC = new LinkedList<>();

    public Hanoi(int disc) {
        numDisc = disc;
        for (int i = 1; i <= disc; i++) {
            towerA.push(i);
        }
    }

    public void solve() {
        move(towerA, towerC, towerB, numDisc);
    }

    private void move(
            LinkedList<Integer> begin, LinkedList<Integer> end, LinkedList<Integer> temp, int n) {
        if (n == 1) {
            end.push(begin.pop());
        } else {
            move(begin, temp, end, n - 1);
            move(begin, end, temp, 1);
            move(temp, end, begin, n - 1);
        }
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(3);
        hanoi.solve();
        System.out.println(hanoi.towerA);
        System.out.println(hanoi.towerB);
        System.out.println(hanoi.towerC);
    }
}
