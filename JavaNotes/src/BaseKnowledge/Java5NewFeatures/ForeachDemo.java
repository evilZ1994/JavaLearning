package BaseKnowledge.Java5NewFeatures;

/**
 * 增强for循环
 */
public class ForeachDemo {
    public static void main(String[] args) {
        int[] data = new int[] {1, 2, 3, 4};
        // foreach循环
        for (int x : data) {
            System.out.println(x);
        }
    }
}
