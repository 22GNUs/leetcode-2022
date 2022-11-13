/*
 * @lc app=leetcode.cn id=92 lang=typescript
 *
 * [92] 反转链表 II
 *
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (55.56%)
 * Likes:    1433
 * Dislikes: 0
 * Total Accepted:    354.6K
 * Total Submissions: 638.2K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left  。请你反转从位置 left 到位置 right 的链表节点，返回
 * 反转后的链表 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目为 n
 * 1 
 * -500 
 * 1 
 * 
 * 
 * 
 * 
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */
function reverseBetween(head: ListNode | null, left: number, right: number): ListNode | null {
    function reverse(head: ListNode | null): void {
        let prev: ListNode | null = null
        while (head !== null) {
            const next = head.next
            head.next = prev
            prev = head
            head = next
        }
    }
    if (head == null) {
        return head
    }
    const dummy = new ListNode(0, head)
    let prev = dummy
    // the start position to break
    let start = head
    // the end position to break
    let end = head
    // find those two positions in listNode
    for (let i = 0; i < right - 1; i++) {
        if (i < left - 1) {
            prev = start
            // notice that the question have asserted '1 <= left <= right <= n'
            // so we can ensure that the start and the end node will not be null
            start = start.next!
        }
        end = end.next!
    }
    const next = end.next
    end.next = null
    // reverse the middle list nodes
    
    reverse(start)

    // reconnect the previous node to the end(new start) and set the start(new node)'s next to the origin one
    prev.next = end
    start.next = next
    return dummy.next
}
// @lc code=end

