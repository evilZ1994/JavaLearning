package DataStructure.Tree.RedBlackTree;

import DataStructure.Sort.ArrayUtil;

public class TestRedBlackTree {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(30, 0, 500);
        RedBlackTree tree = new RedBlackTree();
        for (int v : arr) {
            System.out.print(v+" ");
            tree.insert(new Node(v));
        }
        System.out.println();
        tree.InOrderTraversal();
    }
}
