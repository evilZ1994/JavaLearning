package DataStructure.Tree.BinarySearchTree;

public class TestBST {
    public static void main(String[] args) {
        int[] arr = new int[] {7, 3, 10, 12, 5, 1, 9};
        // 循环添加
        BinarySearchTree bst = new BinarySearchTree();
        for (int v : arr) {
            bst.addNode(new Node(v));
        }
        // 中序遍历（按从小到大的顺序输出）
        bst.middleShow();

        System.out.println("============");
        // 测试查找节点
        System.out.println(bst.search(3));

        System.out.println("============");
        // 测试查找父节点
        System.out.println(bst.searchParent(1).getValue());

        System.out.println("============");
        // 测试删除叶子节点
        bst.delete(5);
        bst.middleShow();

        System.out.println("============");
        // 测试删除只有一个子节点的节点
        bst.delete(3);
        bst.middleShow();

        System.out.println("============");
        // 测试删除有两个子节点的节点
        bst.delete(7);
        bst.middleShow();
    }
}