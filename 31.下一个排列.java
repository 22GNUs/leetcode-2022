import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode.cn/problems/next-permutation/description/
 *
 * algorithms Medium (37.97%) Likes: 1932 Dislikes: 0 Total Accepted: 369.6K Total Submissions:
 * 973.4K Testcase Example: '[1,2,3]'
 *
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 
 * 
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 
 * 
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列
 * 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 
 * 
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 而 arr = [3,2,1] 的下一个排列是
 * [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 
 * 
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 
 * 必须 原地 修改，只允许使用额外常数空间。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3] 输出：[1,3,2]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,2,1] 输出：[1,2,3]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,1,5] 输出：[1,5,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 100 0 <= nums[i] <= 100
 * 
 * 
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // 只有一个数，不需要处理
        if (nums.length <= 1) {
            return;
        }
        // 1. 从右往左，找到第一个 i < i + 1的数
        int i = nums.length - 2;
        // 0的时候也是需要搜索的, 考虑到没有找到排列，最后正好 -1 + 1，从0开始排列
        while (i >= 0) {
            // 这里为什么是 >=，因为比如考虑极端情况[1, 1, 1]，等于的时候也是要前进的
            if (nums[i] >= nums[i + 1]) {
                i--;
                continue;
            }
            // 2. 定位到i, 开始找j，找到第一个大于i的j
            int j = nums.length - 1;
            // 这里为什么是 <=，也是考虑到极端情况，相等的不需要交换
            while (nums[j] <= nums[i]) {
                j--;
                continue;
            }
            // 3. i跟j都找到了，交换
            swap(nums, i, j);
            break;
        }
        // 如果啥也没找到，这里的i就会是-1, 也就会排序出下一个排列
        // 3. 对i的后半部分排序
        Arrays.sort(nums, i + 1, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

