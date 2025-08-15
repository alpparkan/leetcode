import java.util.Comparator;
import java.util.PriorityQueue;

/* 
    https://leetcode.com/problems/k-closest-points-to-origin
    Difficuilty: Medium

    Time complexity: O(klogn)
    Space complexity: O(n)

    Solution: use a minHeap to store distance and its original index(2 element array), get top k elements and return
 */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(t -> t[0]));

        for(int i = 0; i < points.length; i++) {
            int[] p = points[i];
            int distance =  p[0] * p[0] + p[1] * p[1];
            minHeap.offer(new int[]{distance, i});
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] d = minHeap.poll();
            res[i] = points[d[1]];
        }
        return res;
    }
}