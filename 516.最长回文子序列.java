/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 *
 * https://leetcode.cn/problems/longest-palindromic-subsequence/description/
 *
 * algorithms
 * Medium (66.45%)
 * Likes:    798
 * Dislikes: 0
 * Total Accepted:    123.9K
 * Total Submissions: 186.3K
 * Testcase Example:  '"bbbab"'
 *
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 *
 *
 * 示例 2：
 *
 *
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1
 * s 仅由小写英文字母组成
 *
 *
 */

// @lc code=start
class Solution {
  public int longestPalindromeSubseq(String s) {
    int length = s.length();
    // 表示从i -> j的子序列中回文串最大长度
    int[][] dp = new int[length][length];
    for (int i = length - 1; i >= 0; i--) {
      for (int j = i; j < dp.length; j++) {
        if (i == j) {
          dp[i][j] = 1;
          continue;
        }
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    // 长度这里不太一样，因为要找到最长的，并且是从后往前面遍历
    return dp[0][length - 1];
  }
}
// @lc code=end
