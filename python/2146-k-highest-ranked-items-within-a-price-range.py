from collections import deque
import heapq
from typing import List
"""
    https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range
    Difficuilty: Medium

    Time complexity: O(mxnxlogk)
    Space complexity: O(mxn)
    Tags: BFS, Heap, Matrix
    
    Solution: using BFS visit all cells to find out the ones in the given prica range
        - store matching cells in a list as a tuple along with distance, price, row, column
        - also keep a separate list to keep track of visited cells
        - at the en heapify the list of matchin cells and return n smallest items - minHeap
"""

class Solution:
    def highestRankedKItems(self, grid: List[List[int]], pricing: List[int], start: List[int], k: int) -> List[List[int]]:
        # store eligible cells in heap, return top k elements based on their rankings
        heap = list()
        q = deque([start])
        distance = 0
        visited = set()
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        while q:
            distance += 1
            for c in range(len(q)):
                row, col = q.popleft()
                if (row not in range(len(grid)) or col not in range(len(grid[0])) or grid[row][col] == 0
                    or (row, col) in visited):
                    continue

                visited.add((row, col))
                if grid[row][col] in range(pricing[0], pricing[1] + 1):
                    heap.append((distance, grid[row][col], row, col))
                for d in directions:
                    q.append([row + d[0], col + d[1]])
        
        kItems = heapq.nsmallest(k, heap)
        return [[item[2], item[3]] for item in kItems]
        