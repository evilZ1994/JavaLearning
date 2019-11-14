package DataStructure.LinearStructure.Recursive;

public class Hanoi {

    public static void main(String[] args) {
        // 汉诺塔
        hanoi(3, "a", "b", "c");
    }

    /**
     * 汉诺塔Hanoi
     * @param n 共有n个盘子
     * @param from 开始的柱子
     * @param in 中间的柱子
     * @param to 目标柱子
     */
    public static void hanoi(int n, String from, String in, String to) {
        if (n == 1) {
            // 一个盘子时，直接从from移到to
            System.out.println(from + ">" + to);
        } else if (n == 2) {
            // 两个盘子时
            // 小盘子移到中间
            hanoi(1, from, to, in);
            // 大盘子移到目标
            hanoi(1, from, in, to);
            // 把小盘子从中间移到目标
            hanoi(1, in, from, to);
        } else {
            // 盘子超过2个时，把上面n-1个盘子看作一个，最底下一个盘子看作一个
            // 就可以当作两个盘子来处理
            // 将顶上n-1个盘子移到中间
            hanoi(n-1, from, to, in);
            // 将底下盘子移到目标
            hanoi(1, from, in, to);
            // 将顶上n-1个盘子从中间移到目标
            hanoi(n-1, in, from, to);
        }
    }
}
