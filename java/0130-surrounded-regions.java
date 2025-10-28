import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    record Position(int row, int col) {
    }

    public void solve(char[][] board) {
        Set<Position> visited = new HashSet<>();
        Set<int[]> edges = new HashSet<>();
        int rows = board.length;
        int columns = board[0].length;
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                edges.add(new int[] { r, 0 });
            }
            if (board[r][columns - 1] == 'O') {
                edges.add(new int[] { r, columns - 1 });
            }
        }
        for (int c = 0; c < columns; c++) {
            if (board[0][c] == 'O') {
                edges.add(new int[] { 0, c });
            }
            if (board[rows - 1][c] == 'O') {
                edges.add(new int[] { rows - 1, c });
            }
        }

        for (int[] e : edges) {
            dfs(board, visited, e[0], e[1]);
        }
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (board[r][c] == 'O' && !visited.contains(new Position(r, c))) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, Set<Position> visited, int row, int col) {
        List<int[]> directions = List.of(new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 },
                new int[] { 0, 1 });
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                visited.contains(new Position(row, col)) || board[row][col] != 'O') {
            return;
        }
        visited.add(new Position(row, col));
        for (int[] dir : directions) {
            dfs(board, visited, row + dir[0], col + dir[1]);
        }
    }
}