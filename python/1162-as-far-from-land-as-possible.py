from collections import deque
from typing import List
"""
    https://leetcode.com/problems/as-far-from-land-as-possible
    Difficuilty: Medium

    Time complexity: O(mxnxlogk)
    Space complexity: O(mxn)
    Tags: BFS, Matrix, Graph
    
    Solution: revert the problem first and put all of the lands to queue then try to reach farthest water.
        - mark visited water cells as 1 land, so you do not need to visit again.
        - increase step on every queue iteration
"""

class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        maxDistance = -1
        
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        def bfs(r, c):
            q = deque([(r,c)])
            visited = set()
            while q:
                row, col = q.popleft()
                if (row not in range(len(grid)) or col not in range(len(grid[0]))
                    or (row, col) in visited):
                    continue
                if grid[row][col] == 1:
                    return (row,col)
                
                visited.add((row, col))
                for dir in directions:    
                    q.append((row + dir[0], col + dir[1]))
            return None

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 0:
                    coord = bfs(r, c)
                    if(coord):
                        dis = abs(r - coord[0]) + abs(c - coord[1])
                        maxDistance = max(maxDistance, dis)
        return maxDistance
    
    # T: O(mxn), S: T: O(mxn)
    def maxDistance_reverted(self, grid: List[List[int]]) -> int:
        q = deque()
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 1:
                    q.append((r, c))

        res = -1
        if len(q) == len(grid) * len(grid[0]) or len(q) == 0:
            return -1
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while q:
            for _ in range(len(q)):
                r, c = q.popleft()
                for dir in directions:
                    row = r + dir[0]
                    col = c + dir[1] 
                    if (row not in range(len(grid)) or col not in range(len(grid[0]))
                        or grid[row][col] == 1):
                        continue
                    q.append((row, col))
                    grid[row][col] = 1
            res += 1

        return res
