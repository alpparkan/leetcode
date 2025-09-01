from collections import deque
"""
    https://leetcode.com/problems/minimum-knight-moves -> this is a locked premium problem
    Difficuilty: Medium

    Time complexity: O(max(|x|,|y|)²)
    Space complexity: O(max(|x|,|y|)²)
    Tags: BFS, Graph, Matrix
    
    Solution: Using BFS play knight's all possible moves, use directions list
        - When x,y pair equals to current coordinates knight is on return.
        - Keep a visited list, run bfs for at the same time for snapshot of the queue. Increasse step on every snapshot iteration.
        - No need to check boundries since it's an infinite chess board.
"""

class Solution:
    """
    Return the minimum number of steps needed to move the knight 
    from [0, 0] to [x, y].

    Knight moves:
        - (2, 1), (1, 2), (-1, 2), (-2, 1)
        - (-2, -1), (-1, -2), (1, -2), (2, -1)

    Args:
        x (int): Target x coordinate
        y (int): Target y coordinate
    
    Returns:
        int: Minimum number of knight moves required
    """
    def minKnightMoves(self, x, y) -> int:        
        if x == 0 and y == 0:
            return 0
        q = deque([(0,0)])
        visited = set()
        steps = 0
        directions = [(2, 1), (1, 2), (-1, 2), (-2, 1), (-2, -1), (-1, -2), (1, -2), (2, -1)]
        while q:
            steps += 1
            for _ in range(len(q)):
                cx, cy = q.popleft()
                for dir in directions:
                    nx, ny = cx + dir[0], cy + dir[1]
                    
                    if (nx, ny) in visited:
                        continue
                    if x == nx and y == ny:
                        return steps
                    visited.add((nx, ny))
                    q.append((nx, ny))
        return steps

    # Test cases
    def test_minKnightMoves(self):
        # Test case 1: Simple case
        res = self.minKnightMoves(2, 1)
        assert res == 1, f"Expected 1, got {res}"
        
        # # Test case 2: Origin to origin
        assert self.minKnightMoves(0, 0) == 0, f"Expected 0, got {self.minKnightMoves(0, 0)}"
        
        # # Test case 3: Farther distance
        assert self.minKnightMoves(5, 5) == 4, f"Expected 4, got {self.minKnightMoves(5, 5)}"
        
        # # Test case 4: Negative coordinates
        assert self.minKnightMoves(-2, -1) == 1, f"Expected 1, got {self.minKnightMoves(-2, -1)}"
        
        # # Test case 5: Mixed coordinates
        assert self.minKnightMoves(2, -1) == 1, f"Expected 1, got {self.minKnightMoves(2, -1)}"
        
        # # Test case 6: Edge case
        assert self.minKnightMoves(1, 1) == 2, f"Expected 2, got {self.minKnightMoves(1, 1)}"
        
        print("All test cases passed!")

if __name__ == "__main__":
    solution = Solution()

    solution.test_minKnightMoves()