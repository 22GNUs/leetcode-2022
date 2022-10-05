/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode.cn/problems/number-of-islands/description/
 *
 * algorithms Medium (58.68%) Likes: 1934 Dislikes: 0 Total Accepted: 564.3K Total Submissions:
 * 961.6K Testcase Example:
 * '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [ ⁠ ["1","1","1","1","0"], ⁠ ["1","1","0","1","0"], ⁠ ["1","1","0","0","0"], ⁠
 * ["0","0","0","0","0"] ] 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [ ⁠ ["1","1","0","0","0"], ⁠ ["1","1","0","0","0"], ⁠ ["0","0","1","0","0"], ⁠
 * ["0","0","0","1","1"] ] 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length n == grid[i].length 1 grid[i][j] 的值为 '0' 或 '1'
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int ret = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                char value = grid[i][j];
                if (value == '1') {
                    // 发现岛屿
                    // 岛屿数量++
                    ret++;
                    // dfs把该岛屿及其周围全部变为0
                    dfs(grid, i, j);
                }
            }
        }
        return ret;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 边界条件1，超过网格
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        // 边界条件2，已经遇到水了
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        // 往4个方向分别遍历修改
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
// @lc code=end

