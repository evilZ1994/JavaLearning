package DataStructure.Tree.BinaryTree.LinkedStructure;


/**
 * 链式存储的二叉树
 */
public class BinaryTree {
    // 根节点
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
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
    public TreeNode frontSearch(int value) {
        if (root == null) {
            return null;
        }
        return this.root.frontSearch(value);
    }

    // 中序查找
    public TreeNode middleSearch(int value) {
        if (root == null) {
            return null;
        }
        return this.root.middleSearch(value);
    }

    // 后序查找
    public TreeNode afterSearch(int value) {
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
