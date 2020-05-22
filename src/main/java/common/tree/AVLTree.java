package common.tree;

public class AVLTree {

    private Node root;

    public boolean insert(int key) {
        if (root == null) {
            root = new Node(key, null);
        } else {
            Node n = root;
            Node parent;

            while (true) {
                if (n.key == key) return false;

                parent = n;

                boolean goLeft = n.key > key;
                n = goLeft ? n.left : n.right;

                if (n == null) {
                    if (goLeft) {
                        parent.left = new Node(key, parent);
                    } else {
                        parent.right = new Node(key, parent);
                    }
                    rebalance(parent);
                    break;
                }
            }
        }

        return true;
    }

    public void delete(int delKey) {
        if (root == null) return;

        Node node = root;
        Node child = root;

        while (child != null) {
            node = child;
            child = node.key > delKey ? node.right : node.left;
            if (delKey == node.key) {
                delete(node);
                return;
            }
        }
    }

    private void delete(Node node) {
        if (node.left == null && node.right == null) {
            if (node.parent == null) root = null;
            else {
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }

                rebalance(parent);
            }
            return;
        }

        if (node.left != null) {
            Node child = node.left;
            while (child.right != null) {
                child = child.right;
            }
            node.key = child.key;
            delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) {
                child = child.left;
            }
            node.key = child.key;
            delete(child);
        }
    }

    public void printBalance() {
        printBalance(root);
    }

    private void printBalance(Node n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%s ", n.balance);
            printBalance(n.right);
        }

    }


    public boolean search(int key) {
        Node result = searchHelper(this.root, key);
        return result != null;
    }

    private Node searchHelper(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (root.key < key) {
            return searchHelper(root.right, key);
        }

        return searchHelper(root.left, key);
    }


    private void rebalance(Node n) {
        setBalance(n);

        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right)) {
                n = rotateRight(n);
            } else {
                n = rotateLeftThenRight(n);
            }
        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left)) {
                n = rotateLeft(n);
            } else {
                n = rotateRightThenLeft(n);
            }
        }

        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }

    private Node rotateLeft(Node a) {
        Node b = a.right;
        b.parent = a.parent;

        a.right = b.left;
        if (a.right != null) {
            a.right.parent = a;
        }

        b.left = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private Node rotateRight(Node a) {
        Node b = a.left;
        b.parent = a.parent;

        a.left = b.right;
        if (a.left != null) {
            a.left.parent = a;
        }

        b.right = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private Node rotateLeftThenRight(Node a) {
        a.left = rotateLeft(a.left);
        return rotateRight(a);
    }

    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reheight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }

    private void reheight(Node n) {
        if (n != null) {
            n.height = 1 + Math.max(height(n.left), height(n.right));
        }
    }

    private int height(Node n) {
        if (n == null) return -1;
        return n.height;
    }

    private class Node {
        private int key;
        private int balance;
        private int height;
        private Node left, right, parent;

        Node(int k, Node p) {
            this.key = k;
            this.parent = p;
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        System.out.println("Inserting values 1 to 10");
        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
        }

        System.out.print("Printing balance: ");
        tree.printBalance();
        System.out.println();
    }
}
