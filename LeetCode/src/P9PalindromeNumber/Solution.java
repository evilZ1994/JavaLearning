package P9PalindromeNumber;


/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1221));
        System.out.println(new Solution().isPalindrome2(1221));
    }

    public boolean isPalindrome(int x) {
        // 负数不是回文数
        if (x < 0) {
            return false;
        }
        // 先反转
        int y = x;
        int mirror = 0;
        while (y > 0) {
            mirror = mirror * 10 + y % 10;
            y = y / 10;
        }
        return x == mirror;
    }

    public boolean isPalindrome2(int x) {
        // 负数不是回文数
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }
        return i >= j;
    }
}
