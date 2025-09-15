package main

import "strconv"

func findDuplicateSubtrees(root *TreeNode) []*TreeNode {
	result := make([]*TreeNode, 0)
	dfs(root, make(map[string]int), &result)

	return result
}

func dfs(node *TreeNode, visited map[string]int, result *[]*TreeNode) string {
	if node == nil {
		return "null"
	}

	left := dfs(node.Left, visited, result)
	right := dfs(node.Right, visited, result)

	n := strconv.Itoa(node.Val) + "-" + left + "-" + right
	visited[n]++

	if visited[n] == 2 {
		*result = append(*result, node)
	}

	return n
}
