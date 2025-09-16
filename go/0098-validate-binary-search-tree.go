package main

/*
	https://leetcode.com/problems/validate-binary-search-tree
	TC: O(n), we visit every node at most
	SC: O(h), where call stack of recursive DFS function is the height of the tree
*/

import "math"

func isValidBST(root *TreeNode) bool {
	return isValidBST_dfs(root, math.MinInt64, math.MaxInt64)
}

func isValidBST_dfs(node *TreeNode, minVal int, maxVal int) bool {
	if node == nil {
		return true
	}

	return (minVal < node.Val && node.Val < maxVal) &&
		isValidBST_dfs(node.Left, minVal, node.Val) &&
		isValidBST_dfs(node.Right, node.Val, maxVal)
}
