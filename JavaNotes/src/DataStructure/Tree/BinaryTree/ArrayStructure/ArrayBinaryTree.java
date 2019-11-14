package DataStructure.Tree.BinaryTree.ArrayStructure;

/**
 * 线性存储的二叉树
 */
public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow() {
        this.frontShow(0);
    }

    // 前序遍历
    public void frontShow(int index) {
        if (data == null || data.length == 0) {
            return;
        }
        // 先打印自己
        System.out.println(data[index]);
        // 遍历左节点 2*index + 1
        if (2*index + 1 < data.length) {
            frontShow(2*index + 1);
        }
        // 遍历右节点 2*index + 2
        if (2*index + 2 < data.length) {
            frontShow(2*index + 2);
        }
    }

    public void middleShow() {
        this.middleShow(0);
    }

    // 中序遍历
    public void middleShow(int index) {
        if (data == null || data.length == 0) {
            return;
        }
        // 先遍历左节点
        if (2*index + 1 < data.length) {
            middleShow(2*index + 1);
        }
        // 打印自己
        System.out.println(data[index]);
        // 遍历右节点
        if (2*index + 2 < data.length) {
            middleShow(2*index + 2);
        }
    }

    public void afterShow() {
        this.afterShow(0);
    }

    // 后序遍历
    public void afterShow(int index) {
        // 先遍历左节点
        if (index*2 + 1 < data.length) {
            afterShow(index*2 + 1);
        }
        // 遍历右节点
        if (index*2 + 2 < data.length) {
            afterShow(index*2 + 2);
        }
        // 打印自己
        System.out.println(data[index]);
    }
}
