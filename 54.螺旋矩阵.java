import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode.cn/problems/spiral-matrix/description/
 *
 * algorithms Medium (49.16%) Likes: 1228 Dislikes: 0 Total Accepted: 313.9K Total Submissions:
 * 638.7K Testcase Example: '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]] 输出：[1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]] 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length n == matrix[i].length 1 -100
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 按右 -> 下 -> 左 -> 上的优先级去遍历
        // 遍历过了就设置为101(题目设置了数字在 -100 - 100之间)

        int row = matrix.length;
        int column = matrix[0].length;
        int mark = 101;

        int i = 0, j = 0;
        List<Integer> ret = new ArrayList<>();
        // 直到找不到了为止
        while (true) {
            ret.add(matrix[i][j]);

            boolean couldGoRight = j + 1 < column && matrix[i][j + 1] != mark;
            boolean couldGoDown = i + 1 < row && matrix[i + 1][j] != mark;
            boolean couldGoLeft = j - 1 >= 0 && matrix[i][j - 1] != mark;
            boolean couldGoTop = i - 1 >= 0 && matrix[i - 1][j] != mark;

            // 可以向右走
            if (couldGoRight) {
                // 特殊情况
                // 既可以向右走，又可以向上走，左边界的时候，选择向上走
                if (couldGoTop) {
                    matrix[i--][j] = mark;
                    continue;
                }
                matrix[i][j++] = mark;
                continue;
            }
            // 可以向下走
            if (couldGoDown) {
                matrix[i++][j] = mark;
                continue;
            }
            // 可以向左走
            if (couldGoLeft) {
                matrix[i][j--] = mark;
                continue;
            }
            // 可以向上走
            if (couldGoTop) {
                matrix[i--][j] = mark;
                continue;
            }
            break;
        }
        return ret;
    }
}

// @lc code=end

