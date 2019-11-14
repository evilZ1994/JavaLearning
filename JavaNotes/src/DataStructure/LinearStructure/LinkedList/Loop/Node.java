package DataStructure.LinearStructure.LinkedList.Loop;

public class Node {
    // 循环链表
    private int data;
    private Node next=this;

    public Node(int data) {
        this.data = data;
    }

    // 取出节点
    public Node next() {
        return this.next;
    }

    // 删除下一个节点
    public void removeNext() {
        this.next = this.next.next;
    }

    // 插入一个节点作为当前节点的下一个节点
    public void after(Node node) {
        node.next = this.next;
        this.next = node;
    }

    // 取出数据
    public int getData() {
        return data;
    }
}

