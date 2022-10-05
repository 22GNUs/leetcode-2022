/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (69.38%)
 * Likes:    1986
 * Dislikes: 0
 * Total Accepted:    456.9K
 * Total Submissions: 658.7K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [2, 10^5] 内。
 * -10^9 
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 定义问题
        // 1. 当前结点是p或者q，则只要左子树或右子树，有一个包含p或者q
        // 2. 当前结点不是p或者q，则需要左子树和右子树，分别包含p、q

        // 问题演变成了在树里面找左右结点
        // 当前子树的头结点已经是p或者q了，另外一个结点一定在这棵树树里面，所以不用继续找了
        if (root == null || root == p || root == q) {
            // 这里有两种情况，加入root = p，则q要么在root的子树内，此时返回root就是答案
            // 要么q不在root内部，此时返回root，告诉上层找到了p，让上层来决策能不能继续找到q
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 两边都找不到
        if (left == null && right == null) {
            return null;
        }
        
        if (left == null) {
            // 左子树找不到p 或者 q，则一定都在右子树，其实这里利用了题目的一个条件
            // p 和 q 均存在于给定的二叉树中，加入p或者q不在树里面，这样就有问题
            return right;
        }
        if (right == null) {
            return left;
        }
        // 都不为null，说明当前结点就是公共祖先
        return root;
    }
}
// @lc code=end

