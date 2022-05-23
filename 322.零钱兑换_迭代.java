/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (44.93%)
 * Likes:    1894
 * Dislikes: 0
 * Total Accepted:    423.7K
 * Total Submissions: 932.1K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 *
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 *
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 *
 *
 */

// @lc code=start
class Solution {
  public int coinChange(int[] coins, int amount) {
    // 初始化dp数组
    int[] dp = new int[amount + 1];
    // 循环coins，从底向上初始化, 这里不需要从0开始，因为0的值是确定的，一定是0
    for (int targetAmount = 1; targetAmount <= amount; targetAmount++) {
      // 每一轮都遍历零钱尝试凑金额, 每次循环的索引是待凑的金额
      int minCoins = Integer.MAX_VALUE;

      for (int j = 0; j < coins.length; j++) {
        int currentCoins = coins[j];
        if (currentCoins > targetAmount) {
          // 当前零钱不够凑剩余金额，跳过
          continue;
        }
        int restAmount = targetAmount - currentCoins;
        int restCoins = dp[restAmount];

        if (restCoins == -1) {
          // 剩余零钱无法凑出也需要跳过
          continue;
        }
        // 剩余金额
        minCoins = Math.min(minCoins, 1 + restCoins);
      }

      // 没有凑出零钱的情况也需要缓存
      if (minCoins == Integer.MAX_VALUE) {
        minCoins = -1;
      }
      dp[targetAmount] = minCoins;
    }

    return dp[amount];
  }
}
// @lc code=end
