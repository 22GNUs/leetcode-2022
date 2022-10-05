import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode.cn/problems/3sum/description/
 *
 * algorithms
 * Medium (36.30%)
 * Likes:    5286
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 3.2M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
 * k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 
 * 你返回所有和为 0 且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 后续要用到双指针，所以先排序
        Arrays.sort(nums);
        // 用set去重
        Set<List<Integer>> ret = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 因为数组已经排序过，所以如果当前数字已经大于0，不需要再往后计算
            int value = nums[i];
            if (value > 0) {
                break;
            }
            // 从当前数字后面，用twoSum求和
            twoSum(nums, i + 1, nums.length - 1, -value, ret);
        }
        return new ArrayList<>(ret);
    }

    /**
     * 双指针求twoSum
     */
    private void twoSum(
        int[] nums,
        int left,
        int right,
        int target,
        Set<List<Integer>> ret) {
            while (left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                int currentNum = leftNum + rightNum;
                if (currentNum == target) {
                    List<Integer> answer = Arrays.asList(-target, leftNum, rightNum);
                    ret.add(answer);
                    // 找到答案，继续移动左指针寻找
                    left++;
                    continue;
                }
                // 太大了，缩小右指针
                if (currentNum > target) {
                    right--;
                } else {
                    // 太小了，增加左指针
                    left++;
                }
            }
        }
}
// @lc code=end

