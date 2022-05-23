/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 *
 * https://leetcode.cn/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (66.30%)
 * Likes:    873
 * Dislikes: 0
 * Total Accepted:    183.7K
 * Total Submissions: 276.9K
 * Testcase Example:  '"abc"'
 *
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 *
 * 示例 2：
 *
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 *
 *
 */

// @lc code=start
class Solution {
  public int countSubstrings(String s) {
    int length = s.length();
    // 表示从i -> j是否为回文子串
    boolean[][] dp = new boolean[length][length];
    int ans = 0;
    for (int i = dp.length - 1; i >= 0; i--) {
      for (int j = i; j < dp.length; j++) {
        if (s.charAt(i) != s.charAt(j)) {
          dp[i][j] = false;
          continue;
        }
        if (j - i < 3) {
          dp[i][j] = true;
        } else {
          // 这个性质，所以i必须倒着循环，j必须正着循环
          dp[i][j] = dp[i + 1][j - 1];
        }
        if (dp[i][j]) {
          ans++;
        }
      }
    }
    return ans;
  }
}
// @lc code=end
