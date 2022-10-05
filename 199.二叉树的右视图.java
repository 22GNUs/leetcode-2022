import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (65.66%)
 * Likes:    762
 * Dislikes: 0
 * Total Accepted:    243.7K
 * Total Submissions: 371.1K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: []
 * 输出: []
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是 [0,100]
 * -100  
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            TreeNode rightest = null;
            // 层序遍历，每一层放入队列中
            while (i++ < size) {
                rightest = queue.poll();
                if (rightest.left != null) {
                    queue.add(rightest.left);
                }
                if (rightest.right != null) {
                    queue.add(rightest.right);
                }
            }
            // 每一层最右边的结点，放入结果中
            ret.add(rightest.val);
        }
        return ret;
    }
}
// @lc code=end

