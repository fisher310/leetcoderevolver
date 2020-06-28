package common;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {

    private static class Node<T> {
        T value;
        List<Node<T>> next;

        Node(T value) {
            this.value = value;
            next = new ArrayList<>();
        }

        void addNext(Node<T> node) {
            this.next.add(node);
        }
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[9];
        int[] degree = new int[9];

        List<Integer>[] list = new ArrayList[10];

        for (int i = 1; i < 9; i++) {

        }

    }
}
