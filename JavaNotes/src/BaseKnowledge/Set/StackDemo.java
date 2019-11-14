package BaseKnowledge.Set;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        // MyStack
        // 是Vector的子类
        // 栈：先进后出

        // 入栈：public E push(E item)
        // 出栈：public E pop()
        Stack<String> all = new Stack<>();
        all.push("A");
        all.push("B");
        all.push("C");

        for (int i=0; i<all.size(); i++) {
            System.out.println(all.pop());
            // 输出 C B A
        }

//        for (BaseKnowledge.String s : all) {
//            BaseKnowledge.System.out.println(s);
//            // 输出顺序是A B C
//        }
    }
}
