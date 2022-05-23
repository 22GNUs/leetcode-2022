/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (42.50%)
 * Likes:    1636
 * Dislikes: 0
 * Total Accepted:    259.3K
 * Total Submissions: 609.6K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 *
 * 示例 2:
 *
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 *
 * 提示:
 *
 *
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 *
 *
 */

// @lc code=start
class Solution {
  public int maxProduct(int[] nums) {
    int[] maxDP = new int[nums.length];
    int[] minDP = new int[nums.length];
    int result = nums[0];
    maxDP[0] = nums[0];
    minDP[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      // 同时维护max跟min，因为乘法的特殊性，如果乘以一个负数可能导致最大值变成最小值，最小值变成最大值
      // max数组的值一定是当次的计算结果，min数组用于后续计算
      maxDP[i] = Math.max(nums[i], Math.max(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
      minDP[i] = Math.min(nums[i], Math.min(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));

      result = Math.max(maxDP[i], result);
    }
    return result;
  }
}
// @lc code=end
