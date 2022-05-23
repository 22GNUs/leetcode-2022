/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (54.92%)
 * Likes:    4825
 * Dislikes: 0
 * Total Accepted:    1M
 * Total Submissions: 1.8M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 *
 * 示例 2：
 *
 *
 * 输入：nums = [1]
 * 输出：1
 *
 *
 * 示例 3：
 *
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 *
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 */

// @lc code=start
class Solution {
  public int maxSubArray(int[] nums) {
    // 初始化, 把上一次看作0, 无效
    int last = 0;
    int result = nums[0];

    for (int i = 0; i < nums.length; i++) {
      // 这次的计算结果缓存下来，作为下一次的last
      if (last <= 0) {
        // 上一个值小于等于0，无增益
        last = nums[i];
      } else {
        last = last + nums[i];
        // 这个if-else可以简写为 Math.max(last, nums[i] + last)
      }
      // 结果为每个子序列的最大值
      result = Math.max(result, last);
    }

    return result;
  }
}
// @lc code=end
