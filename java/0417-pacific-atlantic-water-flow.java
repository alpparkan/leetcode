import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();

        for (int r = 0; r < heights.length; r++) {
            dfs(heights, r, 0, pac, -1);
            dfs(heights, r, heights[0].length - 1, atl, -1);
        }
        for (int c = 0; c < heights[0].length; c++) {
            dfs(heights, 0, c, pac, -1);
            dfs(heights, heights.length - 1, c, atl, -1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> coord : pac) {
            if (atl.contains(coord)) {
                res.add(coord);
            }
        }
        return res;
    }

    void dfs(int[][] grid, int row, int col, Set<List<Integer>> visited, int prevCellHeight) {
        List<int[]> directions = List.of(new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 },
                new int[] { 0, 1 });

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||
                visited.contains(List.of(row, col)) || prevCellHeight > grid[row][col]) {
            return;
        }

        visited.add(List.of(row, col));
        for (int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1], visited, grid[row][col]);
        }
    }
}