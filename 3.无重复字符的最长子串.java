import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.01%)
 * Likes:    8232
 * Dislikes: 0
 * Total Accepted:    2M
 * Total Submissions: 5.2M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0;
        int maxWindow = 0;
        do {
            char c = s.charAt(right);
            // 当窗口内没有值，或者都被左边界挤出去之后，扩大右边界
            if (!window.contains(c)) {
                right++;
                window.add(c);
                maxWindow = Math.max(maxWindow, window.size());
            } else {
                // 缩小左边界，注意这里并不改变右边界，持续缩小窗口
                window.remove(s.charAt(left++));
            }
        } while (right < length);
        return maxWindow;
    }
}
// @lc code=end

