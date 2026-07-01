from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:

        def dfs(node, remainder):
            if not node:
                return False
            remainder = remainder - node.val
            if remainder == 0 and not node.left and not node.right:
                return True
            return dfs(node.left, remainder) or dfs(node.right, remainder)
        
        return bool(dfs(root, targetSum))

        