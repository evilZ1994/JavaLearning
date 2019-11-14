package P5LongestPalindromicSubstring;

/**
 * 题目描述：
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindrome("bb"));
    }

    public String longestPalindrome(String s) {
        // 遍历每一个字符。然后以当前字符为中心往两边遍历，判断是否是回文串。
        // 有两种情况：1是当前字符与后一个字符相同；2是当前字符的前一个与后一个字符相同
        // 比Solution1好一点
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i=0; i<chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                int b = i;
                int e = i + 1;
                while (b >= 0 && e < chars.length) {
                    if (chars[b] != chars[e]) {
                        break;
                    }
                    b -= 1;
                    e += 1;
                }
                if (e - b - 2 > end - start) {
                    start = b + 1;
                    end = e - 1;
                }
            }
            if (i + 1 < chars.length && i - 1 >= 0 && chars[i - 1] == chars[i + 1]) {
                int b = i - 1;
                int e = i + 1;
                while (b >= 0 && e < chars.length) {
                    if (chars[b] != chars[e]) {
                        break;
                    }
                    b -= 1;
                    e += 1;
                }
                if (e - b - 2 > end - start) {
                    start = b + 1;
                    end = e - 1;
                }
            }
        }
        return new String(chars, start, end - start + 1);
    }
}
