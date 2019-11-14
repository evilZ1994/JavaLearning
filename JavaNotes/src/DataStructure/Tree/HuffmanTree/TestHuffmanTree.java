package DataStructure.Tree.HuffmanTree;

public class TestHuffmanTree {
    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree(new int[]{3, 7, 8, 29, 5, 11, 23, 14});
        System.out.println(tree.getRoot().getValue() + ":" + tree.getRoot().getLeft().getValue() + ":" + tree.getRoot().getRight().getValue());
    }
}
