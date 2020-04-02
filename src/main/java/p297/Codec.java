package p297;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * 二叉树序列化
 */
public class Codec {

  public String serialize(TreeNode root) {
    LinkedList<Integer> list = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        list.add(null);
        continue;
      }
      list.add(node.val);
      queue.offer(node.left);
      queue.offer(node.right);
    }
    while (!list.isEmpty() && list.peekLast() == null) {
      list.removeLast();
    }

    StringJoiner j = new StringJoiner(",", "[", "]");
    for (Integer i : list) {
      j.add(null == i ? "null" : i.toString());
    }
    return j.toString();
  }

  public TreeNode deserialize(String data) {
    if ("[]".equals(data)) return null;
    Queue<TreeNode> queue = new LinkedList<>();
    String[] nums = data.substring(1, data.length() - 1).split(",");
    TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
    queue.offer(root);
    int i = 1;
    while (!queue.isEmpty() && i < nums.length) {
      TreeNode current = queue.poll();
      String nl = nums[i++];
      if (!"null".equals(nl)) {
        current.left = new TreeNode(Integer.parseInt(nl));
        queue.offer(current.left);
      }
      if (i < nums.length) {
        String nr = nums[i++];
        if (!"null".equals(nr)) {
          current.right = new TreeNode(Integer.parseInt(nr));
          queue.offer(current.right);
        }
      }
    }

    return root;
  }

  public static void main(String[] args) {
    Codec codec = new Codec();
    String serialize =
        codec.serialize(TreeNode.createTreeNode(new Integer[] {1, 2, 3, null, null, 4, 5}));
//    String serialize = codec.serialize(TreeNode.createTreeNode(new Integer[]{}));
    System.out.println(serialize);

    TreeNode root = codec.deserialize(serialize);
  }
}
