package P14LongestCommonPrefix;

public class Solution {
    public static void main(String[] args) {
        String[] strs1 = new String[]{"flower", "flow", "flight"};
        String[] strs2 = new String[]{"dog", "racecar", "car"};
        String[] strs3 = new String[]{};
        String[] strs4 = new String[]{"a"};
        String[] strs5 = new String[]{"aa", "a"};
        System.out.println(new Solution().longestCommonPrefix(strs1));
        System.out.println(new Solution().longestCommonPrefix(strs2));
        System.out.println(new Solution().longestCommonPrefix(strs3));
        System.out.println(new Solution().longestCommonPrefix(strs4));
        System.out.println(new Solution().longestCommonPrefix(strs5));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        loop:while (true) {
            for (int j=0; j<strs.length - 1; j++) {
                if (i >= strs[j].length() || i >= strs[j+1].length() || strs[j].charAt(i) != strs[j+1].charAt(i)) {
                    break loop;
                }
            }
            sb.append(strs[0].charAt(i));
            i++;
        }
        return sb.toString();
    }
}
