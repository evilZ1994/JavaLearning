package DataStructure.LinearStructure.LinkedList.DoubleLoop;

public class TestNode {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.after(n2);
        n2.after(n3);
        System.out.println(n1.next().getData());
        System.out.println(n1.pre().getData());
    }
}
