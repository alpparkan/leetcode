from typing import Optional
"""
    https://leetcode.com/problems/rotate-list
    Difficuilty: Medium

    Time complexity: O(n)
    Space complexity: O(1)
    Tags: linked-list

    Solution: get the length of the list and calculate the rotation point, then prepend the list with rotated part.
"""
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next



class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        length = 0
        tmp = head
        while tmp:
            length += 1
            tmp = tmp.next
        
        if k == 0 or not head or length == 1:
            return head

        rotateNum = k % length
        if rotateNum > 0:
            i = length - rotateNum - 1
            tmp = head
            while i > 0:
                i -= 1
                tmp = tmp.next
            newHead = tmp.next
            tmp.next = None

            tmp = newHead
            while tmp.next:
                tmp = tmp.next
            tmp.next = head
            return newHead
        return head