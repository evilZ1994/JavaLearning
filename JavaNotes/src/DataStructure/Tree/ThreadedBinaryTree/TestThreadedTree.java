package DataStructure.Tree.ThreadedBinaryTree;

public class TestThreadedTree {
    public static void main(String[] args) {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.setRoot(new ThreadedTreeNode(1));
        tree.getRoot().setLeft(new ThreadedTreeNode(2));
        tree.getRoot().setRight(new ThreadedTreeNode(3));

        tree.getRoot().getLeft().setLeft(new ThreadedTreeNode(4));
        tree.getRoot().getLeft().setRight(new ThreadedTreeNode(5));

        tree.getRoot().getRight().setLeft(new ThreadedTreeNode(6));
        tree.getRoot().getRight().setLeft(new ThreadedTreeNode(7));

        // 中序线索化二叉树
        tree.middleThreadNodes();
        System.out.println("中序遍历");
        tree.middleShow();
        System.out.println("=========");
        ThreadedTreeNode node = tree.middleSearch(5);
        System.out.println("节点" + node.getValue() +
                " 前一个节点为：" + node.getLeft().getValue() +
                " 后一个节点为：" + node.getRight().getValue());
        System.out.println("线索化中序遍历");
        tree.threadedMiddleShow();
    }
}
