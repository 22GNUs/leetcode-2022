import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 *
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (57.35%)
 * Likes:    698
 * Dislikes: 0
 * Total Accepted:    269.6K
 * Total Submissions: 470.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1]
 * 输出：[[1]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 其实就是层序遍历的变种
        // 核心思路就是把原来的队列换成双端队列
        // 通过变量控制是从前往后插入，还是从后往前插入
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        } 
        Queue<TreeNode> queue = new LinkedList<>();
        // 是否倒序, 默认false
        boolean isReverse = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            Deque<Integer> layer = new ArrayDeque<>();
            // 这个size一定要提前写好, 不要写到for循环里面去
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 这一层的每一个元素，作为结果
                // 并且把下一层的值放入队列
                if (isReverse) {
                    // 倒序，放到前面
                    layer.offerFirst(poll.val);
                } else {
                    // 正序, 放到后面
                    layer.offerLast(poll.val);
                }
            
                TreeNode left = poll.left;
                if (left != null) {
                    queue.add(left);       
                }
                TreeNode right = poll.right;
                if (right != null) {
                    queue.add(right);
                }
            }
            ret.add(new ArrayList<>(layer));
            isReverse = !isReverse;
        }
        return ret;
    }
}
// @lc code=end

