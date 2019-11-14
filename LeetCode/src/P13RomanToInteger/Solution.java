package P13RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i=0; i<chars.length; i++) {
            if (i+1 < chars.length && map.get(chars[i+1]) > map.get(chars[i])) {
                result -= map.get(chars[i]);
            } else {
                result += map.get(chars[i]);
            }
        }
        return result;
    }
}
