package P11ContainerWithMostWater;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        // 92ms
        int len = height.length;
        int max = 0;
        for (int i=0; i<len; i++) {
            // left
            if (i * height[i] > max) {
                for (int j=0; j < i; j++) {
                    if (height[j] >= height[i]) {
                        int result = (i - j) * height[i];
                        max = Math.max(result, max);
                        break;
                    }
                }
            }
            // right
            if ((len - 1 - i) * height[i] > max) {
                for (int j=len-1; j>i; j--) {
                    if (height[j] >= height[i]) {
                        int result = (j - i) * height[i];
                        max = Math.max(result, max);
                        break;
                    }
                }
            }
        }
        return max;
    }
}
