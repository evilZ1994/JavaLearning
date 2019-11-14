package DataStructure.LinearStructure.LinkedList.Single;

public class Node {
    // 单链表
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    // 追加节点
    public Node append(Node node) {
        Node currentNode = this;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return this;
    }

    // 取出节点
    public Node next() {
        return this.next;
    }

    // 删除下一个节点
    public void removeNext() {
        if (this.next != null) {
            this.next = this.next.next;
        }
    }

    // 插入一个节点作为当前节点的下一个节点
    public void after(Node node) {
        node.next = this.next;
        this.next = node;
    }

    // 显示所有节点信息
    public void show() {
        Node currentNode = this;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // 取出数据
    public int getData() {
        return data;
    }
}
