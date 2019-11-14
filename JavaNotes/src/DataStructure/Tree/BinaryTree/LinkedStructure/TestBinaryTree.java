package DataStructure.Tree.BinaryTree.LinkedStructure;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // 设置根节点
        tree.setRoot(new TreeNode(1));
        // 设置根节点的左节点
        tree.getRoot().setLeft(new TreeNode(2));
        // 设置根节点的右节点
        tree.getRoot().setRight(new TreeNode(3));

        tree.getRoot().getLeft().setLeft(new TreeNode(4));
        tree.getRoot().getLeft().setRight(new TreeNode(5));

        tree.getRoot().getRight().setLeft(new TreeNode(6));
        tree.getRoot().getRight().setRight(new TreeNode(7));

        System.out.println("前序遍历");
        tree.frontShow();
        System.out.println("=========");

        System.out.println("中序遍历");
        tree.middleShow();
        System.out.println("=========");

        System.out.println("后序遍历");
        tree.afterShow();
        System.out.println("=========");

        // 查找
        System.out.println(tree.frontSearch(5));
        System.out.println(tree.middleSearch(5));
        System.out.println(tree.afterSearch(5));

        // 删除子树
        tree.delete(2);
        tree.frontShow();
    }
}
