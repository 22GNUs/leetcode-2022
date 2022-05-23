/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms Medium (36.54%) Likes: 5171 Dislikes: 0 Total Accepted: 1M Total Submissions: 2.8M
 * Testcase Example: '"babad"'
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "babad" 输出："bab" 解释："aba" 同样是符合题意的答案。
 *
 *
 * 示例 2：
 *
 *
 * 输入：s = "cbbd" 输出："bb"
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= s.length <= 1000 s 仅由数字和英文字母组成
 *
 *
 */

// @lc code=start
class Solution {
  public String longestPalindrome(String s) {
    int length = s.length();
    if (length < 2) {
      return s;
    }

    // 至少首字母是回文
    int maxLen = 1;
    int begin = 0;

    boolean[][] dp = new boolean[length][length];
    for (int i = length - 1; i >= 0; i--) {
      for (int j = i; j < length; j++) {
        // 1. i == j一定是回文, 由于前面判断了length一定大于
        // 这一步其实不是必须的，因为后面的假j - i < 3已经包括了这个场景，只是处于DP数组的完整，存放了这个值
        if (i == j) {
          dp[i][j] = true;
        } else if (s.charAt(i) != s.charAt(j)) {
          // 2. 如果首尾不相等的，一定不是回文
          dp[i][j] = false;
        } else {
          // 3. 首尾相等的情况下，如果回文字符长度在3以下(比如aba，ab)，则不需要再判断内部的值
          // 注意这些都是j - i，不是i - j
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }

        int currLen = j - i + 1;
        if (dp[i][j] == true && currLen > maxLen) {
          maxLen = currLen;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

}
// @lc code=end
