from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        def dfs(currNode, res):
            if not currNode:
                return
            dfs(currNode.left, res)
            res.append(currNode.val)
            dfs(currNode.right, res)
        
        dfs(root, res)
        return res
        