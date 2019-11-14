package P10RegularExpressionMatching;

public class Solution4 {
    public boolean isMatch(String s, String p) {
        // 官方题解：动态规划 - 自底向上
        // 耗时10ms

        // 从后往前计算（递归其实也是从后往前计算，但这里是用循环实现）
        // 感觉这个解法才是 真·动态规划

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i=s.length(); i>=0; i--) {
            for (int j=p.length() - 1; j>=0; j--) {
                boolean firstMatch = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = (firstMatch && dp[i + 1][j]) || dp[i][j + 2];
                } else {
                    dp[i][j] = (firstMatch && dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
