package p284;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    List<Integer> list;
    int curr = 0;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        curr = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (curr >= list.size()) {
            throw new IllegalStateException();
        }
        return list.get(curr);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (curr >= list.size()) {
            throw new IllegalStateException();
        }
        return list.get(curr++);
    }

    @Override
    public boolean hasNext() {
        return this.curr < list.size();
    }
}
