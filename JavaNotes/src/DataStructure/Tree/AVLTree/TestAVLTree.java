package DataStructure.Tree.AVLTree;

public class TestAVLTree {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        // 创建一颗平衡二叉树
        AVLTree avlTree = new AVLTree();
        // 添加节点
        for (int v : arr) {
            avlTree.addNode(new Node(v));
        }
        // 查看高度
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().getLeft().height());
        System.out.println(avlTree.getRoot().getRight().height());
    }
}
