package P3LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符的最长子串
 *
 * 题目描述：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class Solution {

    public int lengthOfLongestSubstring(String s) {
//        // 时间超出
//        int len = 0;
//        char[] arr = s.toCharArray();
//        List<Character> chars = new ArrayList<>();
//        for (int i=0; i<arr.length; i++) {
//            if (chars.contains(arr[i])) {
//                chars = chars.subList(chars.indexOf(arr[i]) + 1, chars.size());
//            }
//            chars.add(arr[i]);
//            if (len < chars.size()) {
//                len = chars.size();
//            }
//        }
//        return len;
        int len = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        for (int i=0; i<arr.length; i++) {
            for (int j=start; j<i; j++) {
                if (arr[i] == arr[j]) {
                    if ((i - start) > len) {
                        len = (i - start);
                    }
                    start = j + 1;
                    break;
                }
            }
        }
        return len > arr.length - start ? len : arr.length - start;
    }
}
