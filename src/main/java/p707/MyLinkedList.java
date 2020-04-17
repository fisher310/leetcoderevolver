package p707;

/** 设计链表 */
class MyLinkedList {

  private Node head;
  private Node tail;

  private int size;
  /** Initialize your data structure here. */
  public MyLinkedList() {
    head = new Node(0);
    tail = new Node(0);
    head.next = tail;
    tail.prev = head;
    size = 0;
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    if (index < 0 || index >= size) return -1;
    Node curr = head;
    while (index >= 0) {
      curr = curr.next;
      index--;
    }
    return curr.val;
  }

  /**
   * Add a node of value val before the first element of the linked list. After the insertion, the
   * new node will be the first node of the linked list.
   */
  public void addAtHead(int val) {
    Node old = head.next;
    Node newNode = new Node(val);
    newNode.prev = head;
    newNode.next = old;
    head.next = newNode;
    old.prev = newNode;
    size++;
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    Node old = tail.prev;

    Node newNode = new Node(val);
    newNode.prev = old;
    old.next = newNode;
    newNode.next = tail;
    tail.prev = newNode;
    size++;
  }

  /**
   * Add a node of value val before the index-th node in the linked list. If index equals to the
   * length of linked list, the node will be appended to the end of linked list. If index is greater
   * than the length, the node will not be inserted.
   */
  public void addAtIndex(int index, int val) {
    if (index <= 0) {
      // insert head;
      addAtHead(val);
    } else if (index == size) {
      // inser tail;
      addAtTail(val);
    } else if (index < size) {

      Node curr = head;
      while (index >= 0) {
        curr = curr.next;
        index--;
      }
      // 在curr的前面插入
      Node newNode = new Node(val);
      Node pre = curr.prev;

      newNode.prev = pre;
      newNode.next = curr;

      pre.next = newNode;
      curr.prev = newNode;
      size++;
    }
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) return;

    Node curr = head;
    while (index >= 0) {
      curr = curr.next;
      index--;
    }

    // 删除curr;
    Node pre = curr.prev;
    Node next = curr.next;
    pre.next = next;
    next.prev = pre;

    curr.prev = null;
    curr.next = null;
    size--;
  }

  private static class Node {
    int val;
    Node prev;
    Node next;

    Node(int _val) {
      this.val = _val;
    }
  }

  public static void main(String[] args) {
    MyLinkedList linkedList = new MyLinkedList();
    linkedList.addAtHead(1);
    linkedList.addAtTail(3);
    linkedList.addAtIndex(1, 2);
    System.out.println(linkedList.get(1));
    linkedList.deleteAtIndex(1);
    System.out.println(linkedList.get(1));
  }
}
