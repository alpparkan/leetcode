"""
    https://leetcode.com/problems/insert-delete-getrandom-o1/
    Difficuilty: Medium

    Time complexity: O(1)
    Space complexity: O(n)
    Tags: list, hashmap

    Solution:
        - We keep a seperate list just because to use it in the GetRandom() function.
        - Maps are unordered data structures, so we must convert it's keys to a list everytime we want to get a random value which is an O(n) operation, it's also not guaranteed to have an even proablility using map. In order to do the same operation at O(1) constant time we must use a seperate list.
        - On removal of an element from list in O(1) time, we swap the index being removed with last item.
"""

import random


class RandomizedSet:

    def __init__(self):
        self.map = {}
        self.list = []

    def insert(self, val: int) -> bool:
        if val in self.map:
            return False
        self.list.append(val)
        self.map[val] = len(self.list) - 1
        return True
        

    def remove(self, val: int) -> bool:
        if val not in self.map:
            return False
        
        index = self.map[val]
        lastIndex = len(self.list) - 1
        lastElement = self.list[lastIndex]

        # swap last index with removed index 
        self.list[index] = lastElement
        self.list = self.list[:lastIndex]

        # Update map with the new position of the moved element
        self.map[lastElement] = index

        del self.map[val]
        return True

    def getRandom(self) -> int:
        return self.list[random.randint(0, len(self.list) - 1)]
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()