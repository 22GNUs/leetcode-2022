/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (67.68%)
 * Likes:    1819
 * Dislikes: 0
 * Total Accepted:    402.4K
 * Total Submissions: 594.6K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 
 * 
 * 
 * 
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * 
 * 
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
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 这道题的思路，其实很简单
        // 反转前k个，再递归反转k后面的元素
        // 如果元素不到k个，就不再反转
        // 总结: 每K个一组递归反转

        // 如果只有一个元素，则不需要反转
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = head;
        ListNode t = head;
        // 找到链表的前k个, 注意这里是k-1，因为已经有一个head了，并且从0开始，但是是小于
        for (int i = 0; i < k - 1; i++) {
            t = t.next;
            if (t == null) {
                // 链表不到k个，则直接返回
                return head;
            }
        }

        ListNode nextHead = t.next;
        // 断开链表
        t.next = null;

        // 反转后，原来的head变成tail
        ListNode firstHead = reverse(h);
        ListNode secondHead = reverseKGroup(nextHead, k);
        // 原来的head变成tail，接到第二个链表
        h.next = secondHead;
        return firstHead;
    }

    /**
     * 反转链表
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode n = head;
        while (n != null) {
            ListNode next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }
        return prev;
    }
}
// @lc code=end

