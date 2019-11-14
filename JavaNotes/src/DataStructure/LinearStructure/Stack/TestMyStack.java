package DataStructure.LinearStructure.Stack;

public class TestMyStack {
    public static void main(String[] args) {
        // 创建一个栈
        MyStack stack = new MyStack();
        // 压入数据
        stack.push(9);
        stack.push(8);
        stack.push(7);
        // 取出栈顶元素
        System.out.println(stack.pop());
        // 查看栈顶元素
        System.out.println(stack.peek());
        // 判断栈是否为空
        System.out.println(stack.isEmpty());
    }
}
