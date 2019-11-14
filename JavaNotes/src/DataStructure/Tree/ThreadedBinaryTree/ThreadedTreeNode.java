package DataStructure.Tree.ThreadedBinaryTree;

/**
 * 线索化二叉树节点
 */
public class ThreadedTreeNode {
    // 节点的权
    private int value;
    // 左节点
    private ThreadedTreeNode left;
    // 右节点
    private ThreadedTreeNode right;
    // 标识指针类型（默认为0）
    private int leftType;
    private int rightType;

    public ThreadedTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ThreadedTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedTreeNode left) {
        this.left = left;
    }

    public ThreadedTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadedTreeNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    // 前序遍历
    public void frontShow() {
        // 先打印自己的值
        System.out.println(this.value);
        // 然后打印左节点
        if (left != null && leftType == 0) {
            left.frontShow();
        }
        // 最后打印右节点
        if (right != null && rightType == 0) {
            right.frontShow();
        }
    }

    // 中序遍历
    public void middleShow() {
        // 先打印左节点
        if (left != null && leftType == 0) {
            left.middleShow();
        }
        // 然后打印自己
        System.out.println(this.value);
        // 最后打印右节点
        if (right != null && rightType == 0) {
            right.middleShow();
        }
    }

    // 后序遍历
    public void afterShow() {
        // 先打印左节点
        if (left != null && leftType == 0) {
            left.afterShow();
        }
        // 然后打印右节点
        if (right != null && rightType == 0) {
            right.afterShow();
        }
        // 最后打印自己
        System.out.println(this.value);
    }

    // 前序查找
    public ThreadedTreeNode frontSearch(int value) {
        // 先判断自己是不是
        if (this.value == value) {
            return this;
        }
        ThreadedTreeNode target = null;
        // 查找左节点
        if (left != null && leftType == 0) {
            target = left.frontSearch(value);
        }
        // 如果左节点没有，查找右节点
        if (target == null && right != null && rightType == 0) {
            target = right.frontSearch(value);
        }
        return target;
    }

    // 中序查找
    public ThreadedTreeNode middleSearch(int value) {
        // 先查找左节点
        ThreadedTreeNode target = null;
        if (left != null && leftType == 0) {
            target = left.middleSearch(value);
        }
        // 如果左节点没有，判断是否是自己
        if (target == null && this.value == value) {
            return this;
        }
        // 查找右节点
        if (target == null && right != null && rightType == 0) {
            target = right.middleSearch(value);
        }
        return target;
    }

    // 后序查找
    public ThreadedTreeNode afterSearch(int value) {
        // 先查找左节点
        ThreadedTreeNode target = null;
        if (left != null && leftType == 0) {
            target = left.afterSearch(value);
        }
        // 左节点没有，查找右节点
        if (target == null && right != null && rightType == 0) {
            target = right.afterSearch(value);
        }
        // 左右都没有，判断是否是自己
        return this.value == value ? this : target;
    }

    // 删除子树
    public void delete(int value) {
        if (this.left != null && leftType == 0) {
            if (this.left.getValue() == value) {
                this.left = null;
                return;
            }
            this.left.delete(value);
        }
        if (this.right != null && rightType == 0) {
            if (this.right.getValue() == value) {
                this.right = null;
                return;
            }
            this.right.delete(value);
        }
    }
}
