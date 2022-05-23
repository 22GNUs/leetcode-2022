#
# @lc app=leetcode.cn id=206 lang=python3
#
# [206] 反转链表
#

# @lc code=start
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if (head == None):
            return None
        if (head.next == None):
            return head
        tail = ListNode(head.val, None)
        head = self.reverseList(head.next)
        head.next = tail
        return tail

# @lc code=end
