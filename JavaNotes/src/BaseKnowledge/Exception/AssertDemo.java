package BaseKnowledge.Exception;

public class AssertDemo {
    public static void main(String[] args) {
        // Assert断言
        // Java中的断言指的是程序执行到某行代码处时一定是预期的结果
        int num = 10;
        // 中间省略对num操作的许多代码
        num ++;
        // 期望中的内容应该是20
        assert num == 20 : "num的内容不是20";
        System.out.println("num=" + num);
        // 默认情况下断言是不应该影响程序的运行的，也就是说Java解释程序的时候，断言默认是不起作用的
        // 启用断言：
        // java - ea AssertDemo
    }
}
