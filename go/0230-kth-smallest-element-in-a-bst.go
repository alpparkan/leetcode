package main

/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst
Difficulty: Medium
TC: O(n)
SC: O(n)
*/
func kthSmallest(root *TreeNode, k int) int {
	count := 0
	res := 0
	if root == nil {
		return res
	}

	kthSmallest_dfs(root, k, &count, &res)
	return res
}

func kthSmallest_dfs(node *TreeNode, k int, count *int, res *int) {

	if node.Left != nil {
		kthSmallest_dfs(node.Left, k, count, res)
	}

	*count++
	if *count == k {
		*res = node.Val
		return
	}

	if node.Right != nil {
		kthSmallest_dfs(node.Right, k, count, res)
	}
}
