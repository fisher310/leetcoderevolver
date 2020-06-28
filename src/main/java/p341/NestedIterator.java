package p341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 输入: [[1,1],2,[1,1]] <br>
 * 输出: [1,1,2,1,1] <br>
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: <br>
 * [1,1,2,1,1]。
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int curr = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        getNestedInteger(nestedList, list);
    }

    private void getNestedInteger(List<NestedInteger> nestedInteger, List<Integer> list) {
        for (NestedInteger ni : nestedInteger) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                getNestedInteger(ni.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(curr++);
    }

    @Override
    public boolean hasNext() {
        return curr < list.size();
    }

}
