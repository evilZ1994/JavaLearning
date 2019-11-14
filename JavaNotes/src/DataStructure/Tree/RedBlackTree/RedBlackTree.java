package DataStructure.Tree.RedBlackTree;

public class RedBlackTree {
    private Node root;

    /**
     * 插入节点
     */
    public void insert(Node node) {
        if (root == null) {
            root = node;
            root.setColor(Node.Color.BLACK);
            return;
        }
        // 寻找插入点
        Node parent = root;
        Node tmp = root;
        while (tmp != null) {
            parent = tmp;
            if (node.getValue() < tmp.getValue()) {
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        // 插入节点
        if (node.getValue() < parent.getValue()) {
            parent.setLeft(node);
            node.setParent(parent);
        } else {
            parent.setRight(node);
            node.setParent(parent);
        }
        // 当前节点为插入节点
        Node current = node;
        // 如果插入节点的父节点是黑色，直接插入即可
        // 如果插入节点的父节点是红色，则有以下处理
        while (parent != null && parent.getColor() == Node.Color.RED) {
            // 当前节点的父节点是红色，祖父节点一定存在
            // 祖父节点
            Node gParent = parent.getParent();
            // 叔叔节点
            Node uncle;
            if (gParent.getLeft() == parent) {
                // 父节点为祖父节点的左子节点
                uncle = gParent.getRight();
            } else {
                // 父节点为祖父节点的右子节点
                uncle = gParent.getLeft();
            }
            if (uncle != null && uncle.getColor() == Node.Color.RED) {
                // 当前节点的叔叔节点（祖父节点的另一个子节点）也是红色
                // 将当前节点的父节点和叔叔节点变黑，祖父节点变红
                parent.setColor(Node.Color.BLACK);
                uncle.setColor(Node.Color.BLACK);
                gParent.setColor(Node.Color.RED);
                // 当前节点指向祖父节点
                current = gParent;
                parent = current.getParent();
            } else {
                // 当前节点的叔叔节点是黑色的（或者为空）
                if (gParent.getRight() == parent) {
                    // 父节点是祖父节点的右节点
                    if (parent.getLeft() == current) {
                        // 当前节点是其父节点的左子节点
                        // 以当前节点的父节点为支点，做右旋操作
                        rightRotate(parent);
                        // 当前节点指向原来的父节点
                        current = parent;
                        parent = current.getParent();
                    }
                    // 当前节点是其父节点的右子节点
                    // 当前节点的父节点变黑，将祖父节点变红
                    parent.setColor(Node.Color.BLACK);
                    gParent.setColor(Node.Color.RED);
                    // 以祖父节点为支点做左旋操作
                    leftRotate(gParent);
                } else {
                    // 父节点是祖父节点的左节点
                    if (parent.getRight() == current) {
                        // 当前节点是其父节点的右子节点
                        // 以当前节点的父节点为支点，做左旋操作
                        leftRotate(parent);
                        // 当前节点指向原来的父节点
                        current = parent;
                        parent = current.getParent();
                    }
                    // 当前节点是其父节点的左子节点
                    // 当前节点的父节点变黑，将祖父节点变红
                    parent.setColor(Node.Color.BLACK);
                    gParent.setColor(Node.Color.RED);
                    // 以祖父节点为支点做右旋操作
                    rightRotate(gParent);
                }
            }
        }
        // 将根节点变黑
        this.root.setColor(Node.Color.BLACK);
    }

    /**
     * 右旋转
     */
    private void rightRotate(Node node) {
        Node parent = node.getParent();
        Node left = node.getLeft();
        node.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }
        left.setRight(node);
        node.setParent(left);
        if (parent == null) {
            this.root = left;
            this.root.setParent(null);
        } else if (parent.getLeft() == node) {
            parent.setLeft(left);
            left.setParent(parent);
        } else {
            parent.setRight(left);
            left.setParent(parent);
        }
    }

    /**
     * 左旋转
     */
    private void leftRotate(Node node) {
        Node parent = node.getParent();
        Node right = node.getRight();
        node.setRight(right.getLeft());
        if (right.getLeft() != null) {
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
        node.setParent(right);
        if (parent == null) {
            this.root = right;
            this.root.setParent(null);
        } else if (parent.getLeft() == node) {
            parent.setLeft(right);
            right.setParent(parent);
        } else {
            parent.setRight(right);
            right.setParent(parent);
        }
    }

    /**
     * 中序遍历
     */
    public void InOrderTraversal() {
        if (this.root == null) {
            return;
        }
        this.root.InOrderTraversal();
    }

    public Node getRoot() {
        return root;
    }
}
