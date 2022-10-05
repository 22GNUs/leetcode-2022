import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode.cn/problems/permutations/description/
 *
 * algorithms
 * Medium (78.76%)
 * Likes:    2245
 * Dislikes: 0
 * Total Accepted:    735.6K
 * Total Submissions: 934K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1]
 * 输出：[[1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        // 这里不能用set，必须要是有序的，不然tm所有路径的结果都一样了
        Deque<Integer> path = new ArrayDeque<>();
        go(ret, path, nums);
        return ret;
    }

    private void go(List<List<Integer>> ret, Deque<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            // 终止条件，当前路径已经存储了一轮答案
            // 这里队列的查询性能是O(n)，如果要优化查询性能，可以再加一个bool数组
		    // 来维护每个元素是否被访问
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.push(num);
            go(ret, path, nums);
            // 回溯之后，要移除掉自己，不然下一轮会重复
            path.pop();
        }
    }
}
// @lc code=end

