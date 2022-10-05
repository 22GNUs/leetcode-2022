import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode.cn/problems/two-sum/description/
 *
 * algorithms
 * Easy (52.79%)
 * Likes:    15471
 * Dislikes: 0
 * Total Accepted:    3.9M
 * Total Submissions: 7.3M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 
 * 你可以按任意顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 只会存在一个有效答案
 * 
 * 
 * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
 * 
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key - 目标
        // value - 原来的数组下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] ret = new int[2];
                ret[0] = map.get(nums[i]);
                ret[1] = i;
                return ret;
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
// @lc code=end

