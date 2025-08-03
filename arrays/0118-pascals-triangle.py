from typing import List

"""
    https://leetcode.com/problems/pascals-triangle
    Difficuilty: Easy

    Time complexity: O(n * m), where n is total number of rows and m is the number of elements in the last row
    Space complexity: O(n)
"""

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]
        row = 2
        while row <= numRows:
            r = [1]
            
            nonOnes = row - 2
            for i in range(nonOnes):
                previousRow = res[row - 2]
                r.append(previousRow[i] + previousRow[i+1])

            r.append(1)
            res.append(r)
            row += 1
        return res