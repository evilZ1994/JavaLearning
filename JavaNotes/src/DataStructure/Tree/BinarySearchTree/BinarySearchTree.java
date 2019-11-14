package DataStructure.Tree.BinarySearchTree;

public class BinarySearchTree {
    private Node root;

    /**
     * 向二叉查找树中添加节点
     * @param node
     */
    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            this.root.add(node);
        }
    }

    /**
     * 删除节点
     * @param value
     */
    public void delete(int value) {
        if (root == null) {
            return;
        }
        // 找到这个节点
        Node target = search(value);
        if (target == null) {
            return;
        }
        // 找到它的父节点
        Node parent = searchParent(value);
        // 要删除的节点是叶节点
        if (target.getLeft() == null && target.getRight() == null) {
            // 要删除的节点是父节点的左节点
            if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
                parent.setLeft(null);
            } else {
                // 要删除右节点
                parent.setRight(null);
            }
        } else if (target.getLeft() != null && target.getRight() != null) {
            // 要删除的节点有两个子节点
            // 找到目标节点的后继节点，即右子树中最小的节点，删除后继节点，并将目标节点替换为后继节点的值即可
            // 找到右子树最小节点
            Node rightMin = target.getRight();
            while (rightMin.getLeft() != null) {
                rightMin = rightMin.getLeft();
            }
            // 递归调用，删除右子树最小节点
            delete(rightMin.getValue());
            // 替换目标节点的值
            target.setValue(rightMin.getValue());
        } else {
            // 要删除的节点只有一个左子节点或右子节点
            Node child = target.getLeft() != null ? target.getLeft() : target.getRight();
            if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
                // 要删除的节点是父节点的左子节点
                parent.setLeft(child);
            } else {
                // 要删除的节点是父节点的右子节点
                parent.setRight(child);
            }
        }
    }

    /**
     * 搜索父节点
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (this.root == null) {
            return null;
        }
        return this.root.searchParent(value);
    }

    /**
     * 查找节点
     * @param value
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    /**
     * 中序遍历（遍历结果是从小到大）
     */
    public void middleShow() {
        if (root != null) {
            root.middleShow();
        }
    }

    public Node getRoot() {
        return root;
    }
}
