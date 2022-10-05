/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 *
 * algorithms Easy (58.13%) Likes: 2605 Dislikes: 0 Total Accepted: 933.7K Total Submissions: 1.6M
 * Testcase Example: '[7,1,5,3,6,4]'
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：[7,1,5,3,6,4] 输出：5 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。 ⁠ 注意利润不能是
 * 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：prices = [7,6,4,3,1] 输出：0 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 0
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 每天有两种状态，未持有股票，跟已持有股票
        // 未持有股票
        int notHoldStock = 0;
        // 已持有股票
        int holdStock = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 未持有股票状态，前一天未持有，今天也不操作 | 前一天持有，但是今天卖出
            notHoldStock = Math.max(notHoldStock, holdStock + prices[i]);
            // 已持有股票状态，看今天买入是否更便宜，如果今天更便宜，则按今天买入算
            holdStock = Math.max(-prices[i], holdStock);
        }
        // 最后一天一定是全部卖出最划算
        return notHoldStock;
    }
}
// @lc code=end

