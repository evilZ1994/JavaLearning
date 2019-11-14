package P10RegularExpressionMatching;

public class Solution2 {
    public boolean isMatch(String s, String p) {
        // 官方题解：回溯法，耗时148ms
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // 自己增加的优化代码，用时只需17ms（原本需要148ms）
        if (p.length() >= 4 && p.charAt(1) == '*' && p.charAt(3) == '*' && p.charAt(0) == p.charAt(2)) {
            // 删除重复的正则模式，如"a*a*a*a*a*a*a*a*a*a*c"，等价于"a*c"
            return isMatch(s, p.substring(2));
        }

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
