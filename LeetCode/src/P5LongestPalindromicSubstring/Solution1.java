package P5LongestPalindromicSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindrome("bb"));
    }

    public String longestPalindrome(String s) {
        // 遍历每一个字符，用HashMap和ArrayList保存相同字符的下标。
        // 当有相同字符时，取出之前保存的下标，逐一比较两个相同字符之间的字符串是否回文串
        // 时间复杂度和空间复杂度太高
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        Map<Character, List<Integer>> hashMap = new HashMap<>();
        int start = 0;
        int end = 0;
        for (int i=0; i<chars.length; i++) {
            if (!hashMap.containsKey(chars[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(chars[i], list);
            } else {
                int[] indices = getStr(chars, hashMap.get(chars[i]), i);
                if (indices[1] - indices[0] > end - start) {
                    start = indices[0];
                    end = indices[1];
                }
                hashMap.get(chars[i]).add(i);
            }
        }
        return new String(chars, start, end - start + 1);
    }

    public int[] getStr(char[] chars, List<Integer> list, int index) {
        int[] indices = new int[] {0, 0};
        for (int i : list) {
            int s = i;
            int e = index;
            while (s < e) {
                if (chars[s] != chars[e]) {
                    break;
                }
                s += 1;
                e -= 1;
            }
            if (s >= e && (index - i) > (indices[1] - indices[0])) {
                indices[0] = i;
                indices[1] = index;
            }
        }

        return indices;
    }
}

