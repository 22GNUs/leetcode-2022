/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 *
 * https://leetcode.cn/problems/coin-change-2/description/
 *
 * algorithms
 * Medium (68.25%)
 * Likes:    816
 * Dislikes: 0
 * Total Accepted:    159.9K
 * Total Submissions: 234.1K
 * Testcase Example:  '5\n[1,2,5]'
 *
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 
 * 假设每一种面额的硬币有无限个。 
 * 
 * 题目数据保证结果符合 32 位带符号整数。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：amount = 10, coins = [10] 
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * coins 中的所有值 互不相同
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        // 这个完全背包问题的价值跟重量等价
        // 状态转移方程: 放i枚硬币的方案数量 = 放 i - 1枚硬币的方案数量 + 放上第i枚后的数量
        // dp[i][j] = dp[i - 1][j] + dp[i][j - v]
        // 特殊情况
        // 剩余的i = 0的情况不需要考虑，没有硬币肯定都是0
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            int val = coins[i - 1];
            // 至少放入一枚
            for (int j = val; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - val];
            }
        }
        return dp[amount];
    }
}
// @lc code=end

