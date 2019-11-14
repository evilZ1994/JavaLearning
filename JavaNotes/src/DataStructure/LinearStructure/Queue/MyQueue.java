package DataStructure.LinearStructure.Queue;

public class MyQueue {

    int[] elements;

    public MyQueue() {
        this.elements = new int[0];
    }

    // 入队
    public void add(int element) {
        int[] newArr = new int[this.elements.length + 1];
        for (int i=0; i<this.elements.length; i++) {
            newArr[i] = this.elements[i];
        }
        newArr[this.elements.length] = element;
        this.elements = newArr;
    }

    // 出队
    public int poll() {
        if (this.elements.length == 0) {
            throw new RuntimeException("queue is empty");
        }
        int element = this.elements[0];
        int[] newArr = new int[this.elements.length - 1];
        for (int i=0; i<newArr.length; i++) {
            newArr[i] = this.elements[i+1];
        }
        this.elements = newArr;
        return element;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return this.elements.length == 0;
    }
}
