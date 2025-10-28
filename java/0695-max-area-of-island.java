import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = bfs(grid, r, c);
                    maxArea = Math.max(maxArea, a);
                }
            }
        } 
        return maxArea;
    }

    int bfs(int[][] grid, int row, int col) {
        List<int[]> directions = List.of(new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 });
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        int area = 0;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            if (r >=0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                area++;
                grid[r][c] = -1;
                for(int[] dir : directions) {
                    q.offer(new int[]{r+dir[0],c + dir[1]});
                }
            }
        }
        return area;
    }
}