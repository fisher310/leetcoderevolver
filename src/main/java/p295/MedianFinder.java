package p295;

import java.util.PriorityQueue;

/** 数据流的中位数 */
class MedianFinder {

    private PriorityQueue<Integer> lo;
    private PriorityQueue<Integer> hi;

    /** initialize your data structure here. */
    public MedianFinder() {
        lo = new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.offer(num);

        Integer n1 = lo.poll();
        if (null != n1) {
            hi.offer(n1);
        }

        if (hi.size() > lo.size()) {
            Integer n2 = hi.poll();
            lo.offer(n2);
        }
    }

    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
    }

    /**
     * Your MedianFinder object will be instantiated and called as such: MedianFinder obj = new
     * MedianFinder(); obj.addNum(num); double param_2 = obj.findMedian();
     */
}
