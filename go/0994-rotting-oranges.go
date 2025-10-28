package main

/*
https://leetcode.com/problems/rotting-oranges
Difficulty: Medium
TC: O(m*n)
SC: O(m*n)
*/
func orangesRotting(grid [][]int) int {
	row, col := len(grid), len(grid[0])
	queue := make([][2]int, 0)
	fresh := 0

	for r := range row {
		for c := range col {
			switch grid[r][c] {
			case 2:
				queue = append(queue, [2]int{r, c})
			case 1:
				fresh++
			}
		}
	}

	time := 0
	directions := [4][2]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	for fresh > 0 && len(queue) > 0 {
		for range len(queue) {
			head := queue[0]
			queue = queue[1:]

			for _, d := range directions {
				r, c := head[0]+d[0], head[1]+d[1]

				if r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == 1 {
					grid[r][c] = 2
					queue = append(queue, [2]int{r, c})
					fresh--
				}
			}
		}
		time++
	}

	if fresh != 0 {
		return -1
	}
	return time
}
