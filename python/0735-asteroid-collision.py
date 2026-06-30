from typing import List
"""
    https://leetcode.com/problems/asteroid-collision
    Difficuilty: Medium

    Time complexity: O(n)
    Space complexity: O(n)
    Tags: array, stack

    Solution:
        - Collision only occures if top of the stack is positive(going right) and curr a is negative(going left). For all other scenarios append to stack. -> this is how u use while:else
"""

class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []

        for a in asteroids:
            while stack and stack[-1] > 0 and a < 0:
                if stack[-1] + a < 0: # a destroys stack[-1]
                    stack.pop()
                elif stack[-1] + a > 0: # stack[-1] destroys a
                    break
                else: # both are destroyed
                    stack.pop()
                    break
            else:
                stack.append(a)
        return stack
