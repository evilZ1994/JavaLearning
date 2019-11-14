package BaseKnowledge.Link.Demo1;

public class LinkDemo1 {
    public static void main(String[] args) {
        // 准备数据
        Node root = new Node("链表头");
        Node n1 = new Node("节点A");
        Node n2 = new Node("节点B");
        root.setNext(n1);
        n1.setNext(n2);
        // 取出数据
        Node currentNode = root;
//        while(currentNode != null) {
//            BaseKnowledge.System.out.println(currentNode.getValue());
//            currentNode = currentNode.getNext();
//        }
        // 递归方式
        print(currentNode);

        // 对于主方法，对链表的操作过多
        // 由Link类来负责操作链表
        Link link = new Link();
        link.add("Hello");
        link.add("World");
        link.add("Hi");
        link.add("Java");
        link.print();
    }

    private static void print(Node current) {
        if (current == null) {
            return;
        }
        System.out.println(current.getData());
        print(current.getNext());
    }
}

class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public String getData() {
        return this.data;
    }

    public void addNode(Node node) {
        if (this.next == null) {
            this.setNext(node);
        } else {
            this.next.addNode(node);
        }
    }

    public void printNode() {
        System.out.println(this.data);
        if (this.next != null) {
            this.next.printNode();
        }
    }
}

// 负责创建和管理链表
class Link {
    private Node root;

    // 负责数据的设置和输出
    public void add(String data) {
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
    }

    public void print() {
        if (this.root != null) {
            this.root.printNode();
        }
    }
}
