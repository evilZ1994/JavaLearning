package BaseKnowledge.Comparator;

import java.util.Arrays;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 二叉树
        // 和链表类似，也是动态对象数组
        // 但是可以实现排序功能

        // 树的操作原理：选择第一个数据作为根节点，而后比根节点小的放在根节点的左子树（左节点），
        // 比根节点大的放在根节点的右子树（右节点），取的时候按照中序遍历的方法取出（左-中-右）

        // 实现二叉树：
        BinaryTree bt = new BinaryTree();
        bt.add(new Book("Java开发", 80.0));
        bt.add(new Book("Python开发", 78.0));
        bt.add(new Book("JavaScript开发", 60.0));
        bt.add(new Book("Android开发", 90.0));
        System.out.println(Arrays.toString(bt.toArray()));
    }
}

class BinaryTree {
    private class Node {
        private Comparable data;
        private Node left;
        private Node right;

        public Node(Comparable data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (this.data.compareTo(newNode.data) > 0) {
                if (this.left == null) {
                    this.left = newNode;
                } else {
                    this.left.addNode(newNode);
                }
            } else {
                if (this.right == null) {
                    this.right = newNode;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }

        public void toArrayNode() {
            if (this.left != null) {
                this.left.toArrayNode();
            }
            BinaryTree.this.retData[BinaryTree.this.foot++] = this.data;
            if (this.right != null) {
                this.right.toArrayNode();
            }
        }
    }

    private Node root;  // 定义根节点
    private int count; // 定义元素个数
    private Object[] retData;
    private int foot;

    public void add(Comparable obj) {
        Node newNode = new Node(obj);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public Object [] toArray() {
        if (this.root == null) {
            return null;
        }
        this.foot = 0;
        this.retData = new Object[this.count];
        this.root.toArrayNode();
        return this.retData;
    }
}
