package common.tree;

public class RedBlackBST {

    private final int RED = 0;

    private final int BLACK = 1;

    private class Node {
        int key = -1, color = BLACK;
        Node left = nil, right = nil, p = nil;

        Node(int key) {
            this.key = key;
        }
    }

    private final Node nil = new Node(-1);
    private Node root = nil;

    public void printTree(Node node) {
        if (node == nil) {
            return;
        }

        printTree(node.left);
        System.out.print(
                ((node.color == RED) ? " R " : "B")
                        + "Key: "
                        + node.key
                        + " Parent: "
                        + node.p.key
                        + "\n");
        printTree(node.right);
    }

    public void printTreepre(Node node) {
        if (node == nil) {
            return;
        }
        System.out.print(
                ((node.color == RED) ? " R " : " B ")
                        + "Key: "
                        + node.key
                        + "Parent: "
                        + node.p.key
                        + "\n");
        printTreepre(node.left);
        printTreepre(node.right);
    }

    public void insert(int key) {
        insert(new Node(key));
    }

    private Node findNode(Node findNode, Node node) {
        if (root == nil) {
            return null;
        }
        if (findNode.key < node.key) {
            if (node.left != nil) {
                return findNode(findNode, node.left);
            }
        } else if (findNode.key > node.key) {
            if (node.right != nil) {
                return findNode(findNode, node.right);
            }
        } else {
            return node;
        }
        return null;
    }

    private void insert(Node node) {
        Node temp = root;
        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.p = nil;
        } else {
            node.color = RED;
            while (true) {
                if (node.key < temp.key) {
                    if (temp.left == nil) {
                        temp.left = node;
                        node.p = temp;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == nil) {
                        temp.right = node;
                        node.p = temp;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }

            fixTree(node);
        }
    }

    private void fixTree(Node node) {

        while (node.p.color == RED) {
            Node y = nil;
            if (node.p == node.p.p.left) {
                y = node.p.p.right;

                if (y != nil && y.color == RED) {
                    node.p.color = BLACK;
                    y.color = BLACK;
                    node.p.p.color = RED;
                    node = node.p.p;
                    continue;
                }

                if (node == node.p.right) {
                    node = node.p;
                    rotateLeft(node);
                }

                node.p.color = BLACK;
                node.p.p.color = RED;
                rotateRight(node.p.p);
            } else {
                y = node.p.p.left;

                if (y != nil && y.color == RED) {
                    node.p.color = BLACK;
                    y.color = BLACK;
                    node.p.p.color = RED;
                    node = node.p.p;
                    continue;
                }

                if (node == node.p.left) {
                    node = node.p;
                    rotateRight(node);
                }

                node.p.color = BLACK;
                node.p.p.color = RED;
                rotateLeft(node.p.p);
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node node) {
        if (node.p != nil) {
            if (node == node.p.left) {
                node.p.left = node.right;
            } else {
                node.p.right = node.right;
            }
            node.right.p = node.p;
            node.p = node.right;
            if (node.right.left != nil) {
                node.right.left.p = node;
            }
            node.right = node.right.left;
            node.p.left = node;
        } else {
            Node right = root.right;
            root.right = right.left;
            right.left.p = root;
            root.p = right;
            right.left = root;
            right.p = nil;
            root = right;
        }
    }

    private void rotateRight(Node node) {
        if (node.p != nil) {
            if (node == node.p.left) {
                node.p.left = node.left;
            } else {
                node.p.right = node.left;
            }

            node.left.p = node.p;
            node.p = node.left;
            if (node.left.right != nil) {
                node.left.right.p = node;
            }
            node.left = node.left.right;
            node.p.right = node;
        } else {
            Node left = root.left;
            root.left = left.right;
            left.right.p = root;
            root.p = left;
            left.right = root;
            left.p = nil;
            root = left;
        }
    }
}
