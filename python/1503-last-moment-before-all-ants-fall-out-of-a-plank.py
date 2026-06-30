from typing import List

"""
    https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank
    Difficuilty: Medium

    Time complexity: O(n)
    Space complexity: O(1)
    Tags: array

    Solution:
        - Ignore that ants change direction when they meet in the same index, ants are exactly same so considered them pass through each other
"""
class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        lastLeft = 0
        for l in left:
            lastLeft = max(lastLeft, l)
        lastRight = 0
        for r in right:
            lastRight = max(lastRight, (n - r))

        return max(lastLeft, lastRight)

