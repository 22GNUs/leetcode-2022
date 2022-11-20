/*
 * @lc app=leetcode.cn id=56 lang=typescript
 *
 * [56] 合并区间
 *
 * https://leetcode.cn/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (49.21%)
 * Likes:    1716
 * Dislikes: 0
 * Total Accepted:    557.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * 
 * 
 */
function merge(intervals: number[][]): number[][] {
    // 按区间开始, 从小到大排序
    intervals.sort((a, b) => a[0] - b[0])
    const ret = new Array<Array<number>>()
    // 需要注意这里数组从1开始
    let retIdx = -1
    for (const arr of intervals) {
        // 如果结果为空, 或者当前区间开始值，大于结果的区间结束值，则直接放入当前区间
        if (ret.length === 0 || arr[0] > ret[retIdx][1]) {
            ret.push(arr)
            retIdx++
        } else {
            // 小于等于的情况，扩展结果区间
            ret[retIdx][1] = Math.max(arr[1], ret[retIdx][1])
        }
    }
    return ret
};
// @lc code=end