package DataStructure.Tree.ThreadedBinaryTree;

/**
 * 线索二叉树
 */
public class ThreadedBinaryTree {
    ThreadedTreeNode root;
    // 临时存储前驱节点
    ThreadedTreeNode pre = null;

    // 设置根节点
    public void setRoot(ThreadedTreeNode root) {
        this.root = root;
    }

    // 获取根节点
    public ThreadedTreeNode getRoot() {
        return root;
    }

    // 中序线索化二叉树
    public void middleThreadNodes() {
        this.middleThreadNodes(root);
    }

    public void middleThreadNodes(ThreadedTreeNode node) {
        if (node == null) {
            return;
        }
        // 处理左子树
        middleThreadNodes(node.getLeft());
        // 处理前驱节点
        if (node.getLeft() == null) {
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 改变当前节点左指针的类型
            node.setLeftType(1);
        }
        // 处理前驱节点的右指针，如果前驱节点的右指针是null（没有右子树）
        if (pre != null && pre.getRight() == null) {
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 改变前驱节点的右指针类型
            pre.setRightType(1);
        }
        // 每处理一个节点，当前节点是下一个节点的前驱节点
        pre = node;
        // 处理右子树
        middleThreadNodes(node.getRight());
    }

    // 线索二叉树的中序遍历
    public void threadedMiddleShow() {
        // 用于存储当前遍历节点
        ThreadedTreeNode node = root;
        while (node != null) {
            // 循环找到最开始的节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            // 打印
            System.out.println(node.getValue());
            // 如果当前节点的右指针是后继节点，则直接往后找
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node.getValue());
            }
            // 此时node的右指针不是后继节点
            // 根据中序遍历规则，node的左子树已经遍历完了，
            // 且node的值也在上个循环中打印出来了。接下来需要遍历node的右子树
            node = node.getRight();
        }
    }

    // 前序遍历
    public void frontShow() {
        if (root != null) {
            this.root.frontShow();
        }
    }

    // 中序遍历
    public void middleShow() {
        if (root != null) {
            this.root.middleShow();
        }
    }

    // 后序遍历
    public void afterShow() {
        if (root != null) {
            this.root.afterShow();
        }
    }

    // 前序查找
    public ThreadedTreeNode frontSearch(int value) {
        if (root == null) {
            return null;
        }
        return this.root.frontSearch(value);
    }

    // 中序查找
    public ThreadedTreeNode middleSearch(int value) {
        if (root == null) {
            return null;
        }
        return this.root.middleSearch(value);
    }

    // 后序查找
    public ThreadedTreeNode afterSearch(int value) {
        if (root == null) {
            return null;
        }
        return this.root.afterSearch(value);
    }

    // 删除子树
    public void delete(int value) {
        if (this.root != null) {
            if (this.root.getValue() == value) {
                this.root = null;
            } else {
                this.root.delete(value);
            }
        }
    }
}
