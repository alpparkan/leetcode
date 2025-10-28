import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// this can be also solved using a visited map instead of marking cells with # character
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    void bfs(char[][] grid, int row, int col) {
        List<int[]> directions = List.of(new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 },
                new int[] { 0, 1 });
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { row, col });

        while (!q.isEmpty()) {
            int[] cord = q.poll();
            if (cord[0] >= 0 && cord[0] < grid.length && cord[1] >= 0 && cord[1] < grid[0].length
                    && grid[cord[0]][cord[1]] == '1') {
                grid[cord[0]][cord[1]] = '#';
                for (int[] d : directions) {
                    q.offer(new int[] { d[0] + cord[0], d[1] + cord[1] });
                }
            }
        }
    }
}