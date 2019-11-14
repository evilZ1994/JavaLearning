package DataStructure.LinearStructure.LinkedList.DoubleLoop;

public class Node {
    // 上一个节点
    private Node pre = this;
    // 下一个节点
    private Node next = this;
    // 节点数据
    private int data;

    public Node(int data) {
        this.data = data;
    }

    // 增加节点
    public void after(Node node) {
        // 前一个
        this.next.pre = node;
        node.pre = this;
        // 下一个
        node.next = this.next;
        this.next = node;
    }

    // 获取下一个节点
    public Node next() {
        return next;
    }

    // 获取前一个节点
    public Node pre() {
        return this.pre;
    }

    // 获取数据

    public int getData() {
        return data;
    }
}
