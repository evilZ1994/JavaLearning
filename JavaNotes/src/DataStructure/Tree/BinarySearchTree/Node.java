package DataStructure.Tree.BinarySearchTree;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 向子树中添加节点
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 判读传入的节点的值比当前子树的根节点的值大还是小
        if (node.value < this.value) {
            // 往左节点添加
            // 如果左节点为空
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            // 往右节点添加
            // 如果右节点为空
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void middleShow() {
        if (this.left != null) {
            this.left.middleShow();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.middleShow();
        }
    }

    /**
     * 寻找父节点
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        }
        if (this.value > value && this.left != null) {
            return this.left.searchParent(value);
        }
        if (this.value < value && this.right != null) {
            return this.right.searchParent(value);
        }
        return null;
    }

    /**
     * 查找节点
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        }
        if (value < this.value) {
            return this.left == null ? null : this.left.search(value);
        } else {
            return this.right == null ? null : this.right.search(value);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
