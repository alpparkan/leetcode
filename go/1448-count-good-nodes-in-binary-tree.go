package main

func goodNodes(root *TreeNode) int {

	return dfs_goodNodes(root, root.Val)
}

func dfs_goodNodes(node *TreeNode, currentMax int) int {
	if node == nil {
		return 0
	}

	count := 0
	if node.Val >= currentMax {
		count++
	}

	currentMax = max(currentMax, node.Val)

	count += dfs_goodNodes(node.Left, currentMax)
	count += dfs_goodNodes(node.Right, currentMax)

	return count
}

func goodNodes_p(root *TreeNode) int {
	count := 0
	dfs_goodNodes_p(root, root.Val, &count)

	return count
}

func dfs_goodNodes_p(node *TreeNode, currentMax int, count *int) {
	if node == nil {
		return
	}

	if node.Val >= currentMax {
		*count++
	}

	currentMax = max(currentMax, node.Val)

	dfs_goodNodes_p(node.Left, currentMax, count)
	dfs_goodNodes_p(node.Right, currentMax, count)
}
