/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 *
 * https://leetcode.cn/problems/last-stone-weight-ii/description/
 *
 * algorithms
 * Medium (67.02%)
 * Likes:    449
 * Dislikes: 0
 * Total Accepted:    67.9K
 * Total Submissions: 101.3K
 * Testcase Example:  '[2,7,4,1,8,1]'
 *
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 *
 *
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 *
 *
 * 示例 2：
 *
 *
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 *
 */

// @lc code=start
class Solution {
  public int lastStoneWeightII(int[] stones) {
    int sum = 0;
    for (int w : stones) {
      sum += w;
    }

    // 转化为求一半石头重量的背包问题
    int weight = sum / 2;
    int length = stones.length;

    // 这里比较特殊的是背包的价值就 = 石头的重量
    // i = 选择前i块时候, 比如选择前3块石头，那i应该为0，1，2, 所以后面的i都要减1
    // j = 背包容量
    int[][] dp = new int[length + 1][weight + 1];
    // 遍历总石头数量
    // 这里跟01背包不一样的是，这个dp数组的i表示的是石头的数量，因此当石头数量为0的时候，重量一定为0
    for (int i = 1; i <= length; i++) {
      // 遍历重量
      // 容量也是一样的道理，容量为0的时候，重量一定也为0，因此从1开始遍历
      for (int j = 1; j <= weight; j++) {
        // dp[i- 1] 表示上一块
        // stones[i - 1] 表示第i块
        if (j >= stones[i - 1]) {
          // 第i块可以放，也可以不放，不放的话就是取i - 1块石头的重量
          // 放的话就是取用i - 1块石头放满除了当前石头外的最大值 + 当前石头的重量
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    // 最终结果为总重量减去装满一般背包的最大重量 - 剩余重量
    // (sum - dp[stones.length][weight]) - dp[stones.length][weight];
    return sum - 2 * dp[stones.length][weight];
  }
}
// @lc code=end
