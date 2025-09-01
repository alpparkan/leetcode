# Definition for a binary tree node.
from collections import defaultdict
from typing import List, Optional
"""
    https://leetcode.com/problems/find-duplicate-subtrees
    Difficuilty: Medium

    Time complexity: O(n^2) -> tree traversal is O(n) but string concetanation is exponential
    Space complexity: O(n)
    Tags: DFS, Binary-tree
    
    Solution: using DFS traverse tree starting from root
        - store visited nodes in a map: [rep]: count/freq
        - use a custom node representation to be able to compare them while checking if visited -> "n,l,r"
        - if count is more than 1 add node element to output list

        In a skewed tree meaning, string concetenation part makes O(n^2), which is worse then tree traversal
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        # keep a visited set for all pairs, if along the way it's present then put it in to the output
        # use dfs
        visited = defaultdict(int)
        output = set()

        def dfs(node):
            if not node:
                return "N"

            l = dfs(node.left)
            r = dfs(node.right)

            rep = f"{str(node.val)},{str(l)},{str(r)}"
            if visited[rep] == 1:
                output.add(node)
            visited[rep] += 1

            return rep
        
        dfs(root)
        return list(output)
