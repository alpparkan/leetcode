import java.util.Comparator;
import java.util.PriorityQueue;
/*
    https://leetcode.com/problems/find-median-from-data-stream/
    Difficuilty: Hard

    Time complexity: O(logn) for addNum9) and O(1) for findMedian
    Space complexity: O(1) since we have only 26 characters (A-Z)

    Solution: Have 2 different heaps to store each half of the nums. When their size difference is greater than 1 sync them by popping from the bigger heap( in terms of size) and pushing to smaller heap in size.
            - large part will be a minHeap, so top element will be the smallest, closer to middle
            - small part will be a maxHeap, so top element will be the largest, closer to middle
*/

class MedianFinder {
    PriorityQueue<Integer> largeHalf;
    PriorityQueue<Integer> smallHalf;

    public MedianFinder() {
        this.largeHalf = new PriorityQueue<>(); // min heap
        this.smallHalf = new PriorityQueue<>(Comparator.reverseOrder()); // max heap
    }
    
    public void addNum(int num) {
        if (!this.smallHalf.isEmpty() && num < this.smallHalf.peek()) {
            this.smallHalf.offer(num);
        } else {
            this.largeHalf.offer(num);
        }

        if (this.largeHalf.size() - this.smallHalf.size() > 1) {
            Integer syncVal = this.largeHalf.poll();
            this.smallHalf.offer(syncVal);
        }
        else if (this.smallHalf.size() - this.largeHalf.size() > 1) {
            Integer syncVal = this.smallHalf.poll();
            this.largeHalf.offer(syncVal);
        }
    }
    
    public double findMedian() {
        if (this.largeHalf.size() > this.smallHalf.size()) {
            return this.largeHalf.peek();
        } else if (this.smallHalf.size() > this.largeHalf.size()) {
            return this.smallHalf.peek();
        } else {
            return (this.largeHalf.peek() + this.smallHalf.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */