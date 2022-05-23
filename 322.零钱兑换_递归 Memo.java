/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms Medium (44.93%) Likes: 1894 Dislikes: 0 Total Accepted: 423.7K Total Submissions:
 * 932.1K Testcase Example: '[1,2,5]\n11'
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
 * 输入：coins = [1, 2, 5], amount = 11 输出：3 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 *
 *
 * 输入：coins = [2], amount = 3 输出：-1
 *
 * 示例 3：
 *
 *
 * 输入：coins = [1], amount = 0 输出：0
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= coins.length <= 12 1 <= coins[i] <= 2^31 - 1 0 <= amount <= 10^4
 *
 *
 */

// @lc code=start
class Solution {

  public int coinChange(int[] coins, int amount) {
    int[] memo = new int[amount + 1];
    return coinChange(coins, amount, memo);
  }

  public int coinChange(int[] coins, int amount, int[] memo) {
    // 如果硬币已经凑满，则返回路径合法
    if (amount == 0) {
      return 0;
    }

    if (memo[amount] != 0) {
      return memo[amount];
    }

    // 最小硬币数量
    int minCoins = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
      int currentAmount = coins[i];
      if (amount < currentAmount) {
        // 余额减不够，跳过
        continue;
      }

      // 剩余金额
      int restAmount = amount - currentAmount;
      // 剩余硬币
      int restCoins = coinChange(coins, restAmount, memo);
      if (restCoins == -1) {
        // 剩余硬币凑不够，当前硬币也无效
        continue;
      }

      // 当前合法硬币数量 = 自己 + 剩余硬币树
      int currentCoins = restCoins + 1;
      minCoins = Math.min(minCoins, currentCoins);
    }

    memo[amount] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    return memo[amount];
  }
}
// @lc code=end
