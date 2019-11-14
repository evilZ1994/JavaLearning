package DataStructure.LinearStructure.Stack;

public class MyStack {

    int[] elements;

    public MyStack() {
        this.elements = new int[0];
    }

    // 压入元素
    public void push(int element) {
        int[] newArr = new int[this.elements.length + 1];
        for (int i=0; i<this.elements.length; i++) {
            newArr[i] = this.elements[i];
        }
        newArr[this.elements.length] = element;
        this.elements = newArr;
    }

    // 取出栈顶元素
    public int pop() {
        if (this.elements.length == 0) {
            throw new RuntimeException("stack is empty");
        }
        int element = this.elements[this.elements.length - 1];
        int[] newArr = new int[this.elements.length - 1];
        for (int i=0; i<newArr.length; i++) {
            newArr[i] = this.elements[i];
        }
        this.elements = newArr;
        return element;
    }

    // 查看栈顶元素
    public int peek() {
        if (this.elements.length == 0) {
            throw new RuntimeException("stack is empty");
        }
        return this.elements[this.elements.length - 1];
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return this.elements.length == 0;
    }
}
