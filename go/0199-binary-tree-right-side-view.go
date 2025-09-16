package main

/*
	https://leetcode.com/problems/binary-tree-right-side-view
	TC: O(n^2), Dequeue is O(n) and on worst case scenario we do it for every element in tree which is an quadratic time operation
		this can be optimized to linear time, O(n), using container/list instead of a slice as a queue
	SC: O(w), where w is the maximum width of tree, at most we store one level of nodes
*/

func rightSideView(root *TreeNode) []int {
	var res []int
	if root == nil {
		return res
	}
	queue := []*TreeNode{root}

	for len(queue) > 0 {
		length := len(queue)
		farRightIndex := length - 1
		for i := range length {
			node := queue[0]
			queue = queue[1:]

			if i == farRightIndex {
				res = append(res, node.Val)
			}

			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
	}

	return res
}
