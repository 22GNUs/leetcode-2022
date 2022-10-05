/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (57.30%)
 * Likes:    2195
 * Dislikes: 0
 * Total Accepted:    553.7K
 * Total Submissions: 966.3K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 
 * 
 * 示例 2：
 * 
 * 输入：lists = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 输入：lists = [[]]
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode ret = head;
        int totalLength = lists.length;
        // 数组长度，就是有多少个链表
        while (true) {
            // 循环遍历每个数组，找到最小的头结点，作为这一轮的结果
            int minIdx = 0;
            ListNode minNode = null;
            for (int i = 0; i < totalLength; i++) {
                ListNode node = lists[i];
                if (node == null) {
                    continue;
                }
                if (minNode == null || node.val < minNode.val) {
                    minNode = node;
                    minIdx = i;
                }
            }
            if (minNode == null) {
                // 找不出结点了，break
                break;
            }

            // 当前选中节点的数组前进一位
            lists[minIdx] = lists[minIdx].next;
            // 结果加一个
            ret.next = minNode;
            ret = ret.next;
        }
        return head.next;
    }
}
// @lc code=end

