package main

/*
https://leetcode.com/problems/binary-tree-level-order-traversal
Difficulty: Medium
TC: O(n)
SC: O(n)
*/
func levelOrder(root *TreeNode) [][]int {
	res := make([][]int, 0)
	if root == nil {
		return res
	}

	queueu := []*TreeNode{root}

	for len(queueu) > 0 {
		level := make([]int, 0)
		for range len(queueu) {
			node := queueu[0]
			queueu = queueu[1:]

			level = append(level, node.Val)

			if node.Left != nil {
				queueu = append(queueu, node.Left)
			}
			if node.Right != nil {
				queueu = append(queueu, node.Right)
			}
		}
		res = append(res, level)
	}
	return res
}
