package DataStructure.Tree.AVLTree;

public class AVLTree {
    private Node root;

    /**
     * 向平衡二叉树中添加节点
     * @param node
     */
    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            this.root.add(node);
        }
    }

    public Node getRoot() {
        return root;
    }
}
