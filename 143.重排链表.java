/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode.cn/problems/reorder-list/description/
 *
 * algorithms
 * Medium (64.37%)
 * Likes:    1051
 * Dislikes: 0
 * Total Accepted:    214.9K
 * Total Submissions: 333.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * 
 * 
 * L0 → L1 → … → Ln - 1 → Ln
 * 
 * 
 * 请将其重新排列后变为：
 * 
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表的长度范围为 [1, 5 * 10^4]
 * 1 <= node.val <= 1000
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        // 这道题是个大杂烩
        // 1. 找到中间结点
        ListNode middleNode = findMiddleNode(head);
        ListNode left = head;
        ListNode right = middleNode.next;
        // 要点: 这里有点区别是，left到中间结点就要断开了, 虽然链表的中间结点在偶数的时候会靠右一个，但是不影响
        middleNode.next = null;
        // 2. 对右边结点进行反转
        right = reverseNode(right);
        // 3. 按顺序合并两边的链表
        mergeNode(left, right);
    }

    /**
     * 快慢指针，找到中间结点
     */
    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 递归反转链表
     */
    private ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 反转尾巴
        ListNode tail = reverseNode(head.next);
        // 把头结点插入到尾巴
        head.next.next = head;
        // 把尾巴的引用断掉
        head.next = null;
        return tail;
    }

    private void mergeNode(ListNode l1, ListNode l2) {
        // 因为链表长度不会超过1, 所以不用判断有一个链表为null，并一个链表不为空
        // 比如 123 跟 4, 一轮操作就可以完成: 1 -> 4 -> 2 -> 3
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }
}
// @lc code=end

