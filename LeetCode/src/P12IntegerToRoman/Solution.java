package P12IntegerToRoman;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3));
        System.out.println(new Solution().intToRoman(4));
        System.out.println(new Solution().intToRoman(9));
        System.out.println(new Solution().intToRoman(58));
        System.out.println(new Solution().intToRoman(1994));
        System.out.println(new Solution().intToRoman(3999));
    }

    public String intToRoman(int num) {
        String[] dict = new String[] {"I", "V", "X", "L", "C", "D", "M", "", ""};
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int n = num % 10;
            num /= 10;
            String s1 = dict[i];
            String s2 = dict[i+1];
            String s3 = dict[i+2];
            i += 2;
            StringBuilder res = new StringBuilder();
            if (n < 4) {
                for (int j=0; j<n; j++) {
                    res.append(s1);
                }
            } else if (n == 4) {
                res.append(s1).append(s2);
            } else if (n < 9) {
                res.append(s2);
                for (int j=0; j<n-5; j++) {
                    res.append(s1);
                }
            } else {
                res.append(s1).append(s3);
            }
            sb.insert(0, res);
        }
        return sb.toString();
    }
}
