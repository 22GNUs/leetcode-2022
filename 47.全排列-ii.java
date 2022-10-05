import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode.cn/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (65.23%)
 * Likes:    1209
 * Dislikes: 0
 * Total Accepted:    385.8K
 * Total Submissions: 591.3K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        // 这里不能用set，必须要是有序的，不然tm所有路径的结果都一样了
        Deque<Integer> path = new ArrayDeque<>();
        // 先对数组进行排序
        Arrays.sort(nums);
        go(ret, path, nums, -1);
        return ret;
    }

    private void go(
        List<List<Integer>> ret,
        Deque<Integer> path,
        int[] nums,
        int prev) {
        if (path.size() == nums.length) {
            // 终止条件，当前路径已经存储了一轮答案
            // 这里队列的查询性能是O(n)，如果要优化查询性能，可以再加一个bool数组
		    // 来维护每个元素是否被访问
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            // 如果跟上个数组一样，说明为重复，也跳过
            if (path.contains(num) || num == prev) {
                continue;
            }
            path.push(num);
            go(ret, path, nums, num);
            // 回溯之后，要移除掉自己，不然下一轮会重复
            path.pop();
        }
    }
}
// @lc code=end

