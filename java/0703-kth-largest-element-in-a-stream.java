import java.util.PriorityQueue;
/* 
    https://leetcode.com/problems/kth-largest-element-in-a-stream/
    Difficuilty: Easy

    Time complexity: add function O(logn), constructor: O(nlogn) 
    Space complexity: O(n)

    Solution: use a minHeap/PriorityQueue to store elements
 */

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int n : nums) {
            this.minHeap.add(n);
            if (this.minHeap.size() > k) {
                this.minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */