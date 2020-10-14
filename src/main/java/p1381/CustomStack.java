package p1381;

/**
 * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
 * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
 * int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
 * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 * curr [1,2,3]
 * add  [0,1,2] size = 3, pop --> add[0, 3] size = 2 , pop -> add[3] size = 1, pop -> add[0] size = 0
 *
 */
class CustomStack {

    int[] arr;
    int[] add;
    int size;
    int capacity;
    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
        this.add = new int[maxSize];
        this.capacity = maxSize;
        this.size = 0;
    }

    public void push(int x) {
        if (size == capacity) return;
        arr[size++] = x;
    }

    public int pop() {
        if (size == 0) return -1;
        int res = arr[size-1] + add[size-1];
        if (size > 1) {
            add[size - 2] += add[size - 1];
        }
        add[size-1] = 0;
        size--;
        return res;
    }

    public void increment(int k, int val) {
        int pos = Math.min(k-1 , size - 1);
        if (pos >= 0) {
            add[pos] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // 栈是空的 []
        customStack.push(1);                          // 栈变为 [1]
        customStack.push(2);                          // 栈变为 [1, 2]
        customStack.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        customStack.push(2);                          // 栈变为 [1, 2]
        customStack.push(3);                          // 栈变为 [1, 2, 3]
        customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
        customStack.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        customStack.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        customStack.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
        customStack.pop();

    }
}
