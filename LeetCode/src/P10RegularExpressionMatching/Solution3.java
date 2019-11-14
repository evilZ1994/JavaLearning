package P10RegularExpressionMatching;

public class Solution3 {
    enum Result {
        TRUE, FALSE
    }

    Result[][] memo;

    public boolean isMatch(String s, String p) {
        // 官方题解：动态规划 - 自顶向下
        // 耗时4ms

        // 思路还是和回溯法一样，但是因为回溯算法会有很多重复运算，
        // 这里用一个矩阵将每次运算的结果保留下来，节省大量开销

        // 初始化memo矩阵
        memo = new Result[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    public boolean dp(int i, int j, String s, String p) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == p.length()) {
            ans = i == s.length();
        } else {
            boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                ans = dp(i, j + 2, s, p) || (firstMatch && dp(i + 1, j, s, p));
            } else {
                ans = firstMatch && dp(i + 1, j + 1, s, p);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
