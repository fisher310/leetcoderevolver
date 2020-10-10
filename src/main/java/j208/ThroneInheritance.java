package j208;

import java.util.*;

class ThroneInheritance {

    private Map<String, Node> map = new HashMap<>();
    private Set<String> death = new HashSet<>();
    private Node king;

    public ThroneInheritance(String kingName) {
        this.king = new Node(kingName);
        map.put(kingName, this.king);
    }

    public void birth(String parentName, String childName) {
        Node child = new Node(childName);
        map.get(parentName).addChild(child);
        map.put(childName, child);
    }

    public void death(String name) {
        death.add(name);
    }

    public List<String> getInheritanceOrder() {

        List<String> ans = new LinkedList<>();
        preOrder(this.king, ans);
        return ans;
    }

    void preOrder(Node root, List<String> order) {
        if (root == null) return;
        if (!death.contains(root.name)) {
            order.add(root.name);
        }
        for (Node child : root.children) {
            preOrder(child, order);
        }
    }

    private static class Node {
        private String name;
        private List<Node> children;
        Node(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        void addChild(Node child) {
            this.children.add(child);
        }
    }


    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king");
        t.birth("king", "andy"); // 继承顺序：king > andy
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        System.out.println(
                t
                        .getInheritanceOrder()); // 返回 ["king", "andy", "matthew", "bob", "alex",
                                                 // "asha", "catherine"]
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        List<String> ans =
                t
                        .getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "alex", "asha",
                                                // "catherine"]
        System.out.println(ans);
    }
}
