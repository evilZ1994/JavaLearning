package DataStructure.LinearStructure.LinkedList.Single;

public class TestNode {

    public static void main(String[] args) {
        // 创建节点
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        // 追加节点
        n1.append(n2).append(n3).append(new Node(4));
        // 取出下一个节点的数据
        System.out.println(n1.next().next().next().getData());
        // 打印所有节点内容
        n1.show();
        // 删除一个节点
        n1.next().removeNext();
        n1.show();
        // 插入一个新节点
        n1.next().after(new Node(3));
        n1.show();
    }
}
