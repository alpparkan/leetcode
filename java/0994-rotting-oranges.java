import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int totalTime = 0;
        for(int r=0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh ++;
                }
            }
        }

        List<int[]> directions = List.of(new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 });

        while (fresh > 0 && !q.isEmpty()) {
            int initialQLen = q.size(); // this is important: take a snapshot of the inital queue size 
            for (int i = 0; i < initialQLen; i++) { // Run rotting preocess for every rotten oranges within the grid at the same time/minutes
                int[] rotten = q.poll();
                for (int[] d : directions) {
                    int r = rotten[0] + d[0];
                    int c = rotten[1] + d[1];
                    if (r >= 0 && r < grid.length && c >=0 && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[] {r, c});
                        fresh--;
                    }
                }
            }
            totalTime++;
        }

        return fresh == 0 ? totalTime : -1;
    }
}