package common.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private static class Node {
        int element;
        Node left;
        Node right;

        Node(int value) {
            element = value;
        }
    }

    private Node root;

    public BinaryTree() {}

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        insert(root, value);
    }

    private void insert(Node node, int value) {
        if (node.element < value) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        } else if (node.element > value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        }
    }

    public boolean search(int value) {
        return search(root, value) != null;
    }

    public List<Integer> range(int low, int high) {
        List<Integer> res = new ArrayList<>();
        range(root, low, high, res);
        return res;
    }

    private void range(Node node, int low, int high, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (low <= node.element && node.element <= high) {
            res.add(node.element);
            range(node.left, low, high, res);
            range(node.right, low, high, res);
        } else if (node.element < low) {
            range(node.right, low, high, res);
        } else {
            range(node.left, low, high, res);
        }
    }

    private Node search(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.element == value) {
            return node;
        } else if (node.element < value) {
            return search(node.right, value);
        } else {
            return search(node.left, value);
        }
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) return null;
        if (node.element < value) {
            node.right = delete(node.right, value);
        } else if (node.element > value) {
            node.left = delete(node.left, value);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.right != null) {
                Node successor = getSuccessor(node);
                node.element = successor.element;
                node.right = delete(node.right, successor.element);
            } else {
                Node predecessor = getPredecessor(node);
                node.element = predecessor.element;
                node.left = delete(node.left, predecessor.element);
            }
        }

        return node;
    }

    private Node getSuccessor(Node node) {
        Node cur = node.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    private Node getPredecessor(Node node) {
        Node cur = node.left;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        bst.insert(3);
        bst.insert(5);
        bst.insert(9);
        bst.insert(6);

        System.out.println(bst.search(6));
        System.out.println(bst.search(12));

        System.out.println(bst.range(4, 9));

        bst.delete(5);
        System.out.println(bst.search(9));
        System.out.println(bst.search(5));

        System.out.println(bst.range(4, 9));
    }
}
