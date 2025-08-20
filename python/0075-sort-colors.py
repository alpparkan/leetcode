from typing import List
"""
    https://leetcode.com/problems/sort-colors
    Difficuilty: Medium

    Time complexity: O(n)
    Space complexity: O(n)
    Tags: Array
    
    Solution: 2 pass - using an additional array store counts of colors and re-assign original array in the second pass
"""

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        counts = [0] * 3
        for n in nums:
            counts[n] += 1
        
        index = 0
        for color, count in enumerate(counts):
            for _ in range(count):
                nums[index] = color
                index += 1
