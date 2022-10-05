import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode.cn/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (62.09%)
 * Likes:    3862
 * Dislikes: 0
 * Total Accepted:    586.9K
 * Total Submissions: 944.8K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int count = 0;
        // 构造一个栈
        Stack<Wall> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            Wall right = new Wall(i, height[i]);              
            // pop出比wall小的墙壁
            while (!stack.isEmpty() && stack.peek().hight < right.hight) {
                Wall bottom = stack.pop();
                while (!stack.isEmpty() && stack.peek().hight == bottom.hight) {
                    // 如果中间有一样长的bottom，直接drop掉
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    Wall left = stack.peek();
                    count += calculate(left, bottom, right);
                }
            }
            stack.push(right);
        }
        return count;
    }

    private int calculate(Wall left, Wall bottom, Wall right) {
        int width = right.index - left.index - 1;
        int hight = Math.min(left.hight - bottom.hight, right.hight - bottom.hight);
        // 长乘宽 = 雨水面积
        return width * hight;
    }

    private class Wall {
        private int index;
        private int hight;

        public Wall(int index, int hight) {
            this.index = index;
            this.hight = hight;
        }
    }
}
// @lc code=end

