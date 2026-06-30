from typing import List, Optional
"""
    https://leetcode.com/problems/boundary-of-binary-tree/ - premium question
    Difficuilty: Medium

    Time complexity: O(n)
    Space complexity: O(n)
    Tags: tree, DFS

    Solution:
        - Solve it in 3 parts: left boundary(except leaf) - all leaves - right boundary in reverse order(except leaf)
        - Check edge cases first, than create 3 DFS function to cover all different phases of the solution
            - Exclude leaf nodes from left and right boundary collections
            - Left boundary goes always go left, only go right if left is missing. Opposite for right boundary
            - For the right boundary, traverse top down first then append recursively
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def boundary_of_binary_tree(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        if not root.left and not root.right:
            return [root.val]
        
        result = [root.val]

        def get_left_boundary(node):
            if not node or (not node.left and not node.right): # if it's null or a leaf
                return
            
            result.append(node.val)
            if node.left:
                get_left_boundary(node.left)
            else:
                get_left_boundary(node.right)

        def get_leaf_boundary(node):
            if not node:
                return
            
            if not node.left and not node.right:
                result.append(node.val)

            get_leaf_boundary(node.left)
            get_leaf_boundary(node.right)

        def get_right_boundary(node):
            if not node:
                return
            
            if node.right:
                get_right_boundary(node.right)
            else:
                get_right_boundary(node.left)
            
            result.append(node.val)

        get_left_boundary(root.left)
        get_leaf_boundary(root)
        get_right_boundary(root.right)

        return result

