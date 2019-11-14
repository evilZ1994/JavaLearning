package P6ZigzagConversion;

/**
 * Z字形变换
 * 题目描述：
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println(new Solution1().convert("LEETCODEISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        // 耗时15ms，内存39.8MB
        // 看起来很复杂，自己都不想看第二遍
        // 大概思路是有一个字符数组保存新的字符串，遍历字符串s中的每个字符，然后计算当前字符在新数组中的位置。
        if (numRows == 1) {
            return s;
        }
        char[] chars = new char[s.length()];
        int interval = 2*numRows - 2;  // 每一个间隔的数目（一个V字型）
        int top_num = (int)Math.ceil((double)s.length() / interval);  // 第一行的字符数目
        int last_num = s.length() - (top_num - 1) * interval;  //
        int bot_num = top_num - 1 + last_num/numRows;  // 最后一行的字符数目
        int pos;
        for (int i=0; i<s.length(); i++) {
            pos = i % interval;  // 在一个间隔中的位置
            // 如果是第一行和最后一行，可以直接计算字符位置
            // 其他行则有两种情况
            if (pos == 0) {
                chars[i/interval] = s.charAt(i);
            } else if (pos == numRows - 1) {
                chars[s.length() - bot_num + i/interval] = s.charAt(i);
            } else if (pos < numRows - 1){
                // 最后一个间隔可能是不完整的，先计算前面top_num - 1个完整间隔中在当前字符之前的字符数
                // 然后再计算最后一个间隔中在当前字符之前的字符数
                int temp;
                if (last_num < numRows) {
                    temp = Math.min(last_num, pos);
                } else {
                    temp = pos + Math.max(0, last_num - 1 - ((numRows - 1 - pos) * 2 + pos));
                }
                // 第一行的字符数 + 所有完整间隔中的在此之前的字符数 + 最后一个间隔 + 同一行中当前字符之前的字符数
                chars[top_num - 1 + (top_num - 1) * (pos - 1) * 2  + temp + (i/interval) * 2] = s.charAt(i);
            } else {
                int temp;
                if (last_num < numRows) {
                    temp = Math.min(last_num, numRows - 1 - (pos - numRows + 1));
                } else {
                    temp = numRows - 1 - (pos - numRows + 1) + Math.max(0, last_num - 1 - pos);
                }
                chars[top_num - 1 + (top_num - 1) * (numRows - 1 - (pos - numRows + 1) - 1) * 2 + temp + (i/interval) * 2 + 1] = s.charAt(i);
            }
        }
        return new String(chars);
    }
}
