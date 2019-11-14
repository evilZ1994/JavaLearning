package DataStructure.Tree.RedBlackTree;

public class Node {

    public enum Color {
        RED, BLACK
    }

    private int value;
    // 默认节点颜色为红色
    private Color color = Color.RED;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 中序遍历
     */
    public void InOrderTraversal() {
        if (this.left != null) {
            this.left.InOrderTraversal();
        }
        System.out.print(this.value + " ");
        if (this.right != null) {
            this.right.InOrderTraversal();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
