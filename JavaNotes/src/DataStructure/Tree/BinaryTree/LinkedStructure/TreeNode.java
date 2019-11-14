package DataStructure.Tree.BinaryTree.LinkedStructure;

public class TreeNode {
    // 节点的权
    private int value;
    // 左节点
    private TreeNode left;
    // 右节点
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    // 前序遍历
    public void frontShow() {
        // 先打印自己的值
        System.out.println(this.value);
        // 然后打印左节点
        if (left != null) {
            left.frontShow();
        }
        // 最后打印右节点
        if (right != null) {
            right.frontShow();
        }
    }

    // 中序遍历
    public void middleShow() {
        // 先打印左节点
        if (left != null) {
            left.middleShow();
        }
        // 然后打印自己
        System.out.println(this.value);
        // 最后打印右节点
        if (right != null) {
            right.middleShow();
        }
    }

    // 后序遍历
    public void afterShow() {
        // 先打印左节点
        if (left != null) {
            left.afterShow();
        }
        // 然后打印右节点
        if (right != null) {
            right.afterShow();
        }
        // 最后打印自己
        System.out.println(this.value);
    }

    // 前序查找
    public TreeNode frontSearch(int value) {
        // 先判断自己是不是
        if (this.value == value) {
            return this;
        }
        TreeNode target = null;
        // 查找左节点
        if (left != null) {
            target = left.frontSearch(value);
        }
        // 如果左节点没有，查找右节点
        if (target == null && right != null) {
            target = right.frontSearch(value);
        }
        return target;
    }

    // 中序查找
    public TreeNode middleSearch(int value) {
        // 先查找左节点
        TreeNode target = null;
        if (left != null) {
            target = left.middleSearch(value);
        }
        // 如果左节点没有，判断是否是自己
        if (target == null && this.value == value) {
            return this;
        }
        // 查找右节点
        if (target == null && right != null) {
            target = right.middleSearch(value);
        }
        return target;
    }

    // 后序查找
    public TreeNode afterSearch(int value) {
        // 先查找左节点
        TreeNode target = null;
        if (left != null) {
            target = left.afterSearch(value);
        }
        // 左节点没有，查找右节点
        if (target == null && right != null) {
            target = right.afterSearch(value);
        }
        // 左右都没有，判断是否是自己
        return this.value == value ? this : target;
    }

    // 删除子树
    public void delete(int value) {
        if (this.left != null) {
            if (this.left.getValue() == value) {
                this.left = null;
                return;
            }
            this.left.delete(value);
        }
        if (this.right != null) {
            if (this.right.getValue() == value) {
                this.right = null;
                return;
            }
            this.right.delete(value);
        }
    }
}
