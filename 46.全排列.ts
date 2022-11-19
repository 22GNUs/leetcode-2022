/*
 * @lc app=leetcode.cn id=46 lang=typescript
 *
 * [46] 全排列
 *
 * https://leetcode.cn/problems/permutations/description/
 *
 * algorithms
 * Medium (78.79%)
 * Likes:    2305
 * Dislikes: 0
 * Total Accepted:    759.6K
 * Total Submissions: 964.2K
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
function permute(nums: number[]): number[][] {
    const len = nums.length
    const ret = new Array<Array<number>>()
    function go(path: number[]): void {
        if (path.length === len) {
            ret.push([...path])
            return
        }
        for (const val of nums) {
            if (path.includes(val)) {
                continue
            }
            path.push(val)
            go(path)
            // 递归后移除自己，走下一条分支
            path.pop()
        }
    }
    go([])
    return ret
}