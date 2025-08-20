"""
    https://leetcode.com/problems/partition-list
    Difficuilty: Medium

    Time complexity: O(?)
    Space complexity: O(?)
    Tags: linked-list

    Solution:
"""

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        if not head or (head and head.next == None):
            return head

        tmp = ListNode(0, head)
        s, l = tmp, tmp
        r = head

        while r:
            if r.val >= x:
                l = l.next
                r = r.next
            elif l == s and r.val < x:
                l = s = l.next
                r = r.next
            else:
                nxt = r.next
                l.next = nxt

                snxt = s.next
                s.next = r
                r.next = snxt

                s = s.next
                r = nxt
        return tmp.next
