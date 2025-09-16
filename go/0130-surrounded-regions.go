package main

/*
	TC: O(r*c)
	SC: O(r*c)
*/

func solve(board [][]byte) {

	for r := range len(board) {
		solve_dfs(board, r, 0)
		solve_dfs(board, r, len(board[0])-1)
	}
	for c := range len(board[0]) {
		solve_dfs(board, 0, c)
		solve_dfs(board, len(board)-1, c)
	}

	for r := range len(board) {
		for c := range len(board[0]) {
			if board[r][c] == 'O' {
				board[r][c] = 'X'
			} else if board[r][c] == '&' {
				board[r][c] = 'O'
			}
		}
	}
}

func solve_dfs(board [][]byte, row int, col int) {
	if row < 0 || row >= len(board) || col < 0 || col >= len(board[0]) ||
		board[row][col] == 'X' || board[row][col] == '&' { // if it's & than it's been already visited
		return
	}

	board[row][col] = '&'

	directions := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	for _, d := range directions {
		solve_dfs(board, row+d[0], col+d[1])
	}
}
