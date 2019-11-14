package DataStructure.Tree.BinaryTree.ArrayStructure;

public class TestArrayBinary {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);

        System.out.println("前序遍历");
        tree.frontShow();
        System.out.println("===========");

        System.out.println("中序遍历");
        tree.middleShow();
        System.out.println("===========");

        System.out.println("后序遍历");
        tree.afterShow();
        System.out.println("===========");
    }
}
