# 树-概述

![](http://upyun.ishavanti.top/img/Tree.jpg)

结构概述：

- 根节点：树的顶点（图中"28"）

- 双亲节点：如"28"是"16"和"30"的双亲节点

- 子节点：如"16"和"30"是"28"的子节点

- 路径：从根节点访问其他节点所要经过的节点，如"28->16->22"

- 节点的度：即这个节点有多少个子节点，如节点"28"的度为2，节点"16"的度为0

- 节点的权：即节点所对应的值，如节点"28"的权为28

- 叶子节点：没有子节点的节点，如"13", "22", "29", "42"

- 子树：如(16, 13, 22)为一颗子树

- 层：树可以被分为多层，如根节点28的层为1，（16，30）两个节点的层为2，剩余节点的层为3

- 树的高度：即树的最大层数，此树的高度为3

- 森林：多棵树组成森林

# 二叉树

- 任何一个节点的子节点的数量不超过2

- 二叉树的子节点分为左节点和右节点

## 满二叉树

- 所有叶子节点都在最后一层
- 节点总数为：2^n - 1 (n是树的高度)

![](http://upyun.ishavanti.top/img/FullBinaryTree.png)

## 完全二叉树

- 所有叶子节点都在最后一层，或倒数第二层
- 最后一层的叶子节点在左边连续，倒数第二层的叶子节点在右边连续

![](http://upyun.ishavanti.top/img/CompleteBinaryTree.png)

# 创建和遍历二叉树

## 链式存储

**TreeNode.class:**

```java
public class TreeNode {
    // 节点的权
    private int value;
    // 左节点
    private TreeNode left;
    // 右节点
    private TreeNode right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode(int value) {
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
}
```

**BinaryTree.class:**

```java
public class BinaryTree {
    // 根节点
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }
}
```

**TestBinaryTree.class**

```java
public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // 设置根节点
        tree.setRoot(new TreeNode(1));
        // 设置根节点的左节点
        tree.getRoot().setLeft(new TreeNode(2));
        // 设置根节点的右节点
        tree.getRoot().setRight(new TreeNode(3));

        tree.getRoot().getLeft().setLeft(new TreeNode(4));
        tree.getRoot().getLeft().setRight(new TreeNode(5));

        tree.getRoot().getRight().setLeft(new TreeNode(6));
        tree.getRoot().getRight().setRight(new TreeNode(7));
    }
}
```

## 遍历二叉树

![](http://upyun.ishavanti.top/img/BinaryTree2.png)

- 前序遍历：**根 - 左 - 右** 的遍历顺序（1, 2, 4, 5, 3, 6, 7）
- 中序遍历：**左 - 根 - 右** 的遍历顺序（4, 2, 5, 1, 6, 3, 7）
- 后序遍历：**左 - 右 - 根** 的遍历顺序（4, 5, 2, 6, 7, 3, 1）

**TreeNode.class**

```java
public class TreeNode {
    // .....
  
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
}
```

**BinaryTree.class**

```java
public class BinaryTree {
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
}
```

**TestBinaryTree.class**

```java
public class TestBinaryTree {
    public static void main(String[] args) {
        // .....
        System.out.println("前序遍历");
        tree.frontShow();
        System.out.println("=========");

        System.out.println("中序遍历");
        tree.middleShow();
        System.out.println("=========");

        System.out.println("后序遍历");
        tree.afterShow();
        System.out.println("=========");
    }
}
```

## 查找

前序查找，中序查找，后序查找

**TreeNode.class**

```java
public class TreeNode {
    // .....
  
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
}
```

**BinaryTree.class**

```java
public class BinaryTree {
    // .....
  
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
}
```

**TestBinaryTree.class**

```java
public class TestBinaryTree {
    public static void main(String[] args) {
				// .....
      
        // 查找
        System.out.println(tree.frontSearch(5));
        System.out.println(tree.middleSearch(5));
        System.out.println(tree.afterSearch(5));
    }
}
```

## 删除子树

**TreeNode.class**

```java
public class TreeNode {
    // .....
  
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
```

**BinaryTree.class**

```java
public class BinaryTree {
    // .....
  
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
```

**TestBinaryTree.class**

```java
public class TestBinaryTree {
    public static void main(String[] args) {
				// .....

        // 删除子树
        tree.delete(2);
        tree.frontShow();
    }
}
```

## 顺序存储

用顺序结构（数组）按层顺序存储。

![](http://upyun.ishavanti.top/img/BinaryTree3.png)

- 顺序存储的二叉树通常只考虑[完全二叉树](#完全二叉树)
- 第n个元素的左子节点为：2*n + 1
- 第n个元素的右子节点为：2*n + 2
- 第n个元素的父节点为：(n - 1) / 2

**ArrayBinaryTree.class**

```java
public class ArrayBinaryTree {
    int[] value;

    public ArrayBinaryTree(int[] value) {
        this.value = value;
    }

    public void frontShow() {
        this.frontShow(0);
    }

    // 前序遍历
    public void frontShow(int index) {
        if (value == null || value.length == 0) {
            return;
        }
        // 先打印自己
        System.out.println(value[index]);
        // 遍历左节点 2*index + 1
        if (2*index + 1 < value.length) {
            frontShow(2*index + 1);
        }
        // 遍历右节点 2*index + 2
        if (2*index + 2 < value.length) {
            frontShow(2*index + 2);
        }
    }

    public void middleShow() {
        this.middleShow(0);
    }

    // 中序遍历
    public void middleShow(int index) {
        if (value == null || value.length == 0) {
            return;
        }
        // 先遍历左节点
        if (2*index + 1 < value.length) {
            middleShow(2*index + 1);
        }
        // 打印自己
        System.out.println(value[index]);
        // 遍历右节点
        if (2*index + 2 < value.length) {
            middleShow(2*index + 2);
        }
    }

    public void afterShow() {
        this.afterShow(0);
    }

    // 后序遍历
    public void afterShow(int index) {
        // 先遍历左节点
        if (index*2 + 1 < value.length) {
            afterShow(index*2 + 1);
        }
        // 遍历右节点
        if (index*2 + 2 < value.length) {
            afterShow(index*2 + 2);
        }
        // 打印自己
        System.out.println(value[index]);
    }
}
```

**TestArrayBinary.class**

```java
public class TestArrayBinary {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);

        System.out.println("前序遍历");
        tree.frontShow();
        System.out.println("===========");

        System.out.println("中序遍历");
        tree.middleShow();
        System.out.println("===========");

        System.out.println("后序遍历");
        tree.afterShow();
        System.out.println("===========");
    }
}
```

## 堆排序

**堆**：对于任意一颗子树，它的父节点都大于（或者小于）子节点。

**大顶堆**：父节点的值大于子节点

**小顶堆**：父节点的值小于子节点

![](http://upyun.ishavanti.top/img/HeapSort.gif)

```java
public class HeapSort {
    /**
     * 调整为大顶堆
     * @param arr 数组
     * @param size 需要调整的大小
     * @param index 最后一个叶子节点的父节点位置
     */
    public static void maxHeap(int[] arr, int size, int index) {
        // 左节点位置
        int left = index * 2 + 1;
        // 右节点位置
        int right = index * 2 + 2;
        // 记录最大值
        int maxIndex = index;
        // 寻找最大值的节点
        if (left < size && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < size && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        // 将最大值交换到当前节点
        if (index != maxIndex) {
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
            // 交换后可能影响到之前的堆
            maxHeap(arr, size, maxIndex);
        }
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {
        // 将数组调整为大顶堆 (arr.length - 2)/2 为数组中最后一个节点的父节点位置，第n个节点的父节点计算：(n-1)/2
        for (int i=(arr.length - 2) / 2; i>=0; i--) {
            maxHeap(arr, arr.length, i);
        }
        // 交换顶点和待排数组中最后一个节点，然后将最后一个节点隔离后，将剩余数组调整为大顶堆
        for (int i=arr.length-1; i>0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }
}
```

# 线索二叉树

![](http://upyun.ishavanti.top/img/BinaryTree4.png)

普通的二叉树如图，左右两个指针分别指向左子节点和右子节点。

存在两个问题：

- 在遍历节点时，无法直接知道一个节点的前一个节点或者后一个节点
- 叶子节点的左右指针空闲

## 线索化二叉树

![](http://upyun.ishavanti.top/img/MiddleThreadedBinaryTree.png)

如图为**"中序线索化二叉树"**（同理，还有**"前序线索化二叉树"**，**"后序线索化二叉树"**，实现方式类似）

在中序线索化二叉树时，将叶子节点空闲的左节点指向其前一个节点，将空闲的右节点指向其后一个节点。比如节点**7**在中序序列中的前一个节点为**5**，后一个节点为**8**。

然后我们需要知道指针指向的到底是左右子节点，还是前后节点。于是对于左右指针，各增加一个标识变量，**0**表示指向左右子节点，**1**表示指向前后节点。

## 代码实现

**ThreadedTreeNode.class**

```java
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
```

**ThreadedBinaryTree.class**

```java
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

  	// 中序线索化二叉树
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
```

**TestThreadedTree.class**

```java
public class TestThreadedTree {
    public static void main(String[] args) {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.setRoot(new ThreadedTreeNode(1));
        tree.getRoot().setLeft(new ThreadedTreeNode(2));
        tree.getRoot().setRight(new ThreadedTreeNode(3));

        tree.getRoot().getLeft().setLeft(new ThreadedTreeNode(4));
        tree.getRoot().getLeft().setRight(new ThreadedTreeNode(5));

        tree.getRoot().getRight().setLeft(new ThreadedTreeNode(6));
        tree.getRoot().getRight().setLeft(new ThreadedTreeNode(7));

        // 中序线索化二叉树
        tree.middleThreadNodes();
        System.out.println("中序遍历");
        tree.middleShow();
        System.out.println("=========");
        ThreadedTreeNode node = tree.middleSearch(5);
        System.out.println("节点" + node.getValue() +
                " 前一个节点为：" + node.getLeft().getValue() +
                " 后一个节点为：" + node.getRight().getValue());
        System.out.println("线索化中序遍历");
        tree.threadedMiddleShow();
    }
}
```

前序线索化和后序线索化实现方式类似。

# 赫夫曼树

给定n个权值作为n个叶子结点，构造一棵二叉树，若该树的带权路径长度达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman Tree)。哈夫曼树是带权路径长度最短的树，权值较大的结点离根较近。

## 概述

A，B，C，D四个叶子节点可排列出若干种二叉树，图中为其中3种：

![](http://upyun.ishavanti.top/img/HuffmanTree.png)

- 最优二叉树：它是n个带权叶子节点构成的所有二叉树中，带权路径长度最小的二叉树
- 叶节点的带权路径长度：从根节点到该节点经过的节点数乘以该节点的权值。如图(a)节点A的带权路径为：2*9=18，节点B的带权路径为8
- 树的带权路径长度WPL(weighted path length)：树中所有叶子节点的带权路径长度之和

图中三颗树的WPL：

- (a): WPL = 9\*2 + 4\*2 + 5\*2 + 2\*2 = 40
- (b): WPL = 9\*1 + 5\*2 + 4\*3 + 2\*3 = 37
- (c): WPL = 4\*1 + 2\*2 + 5\*3 + 9\*3 = 50

WPL最小的树称为**最优二叉树**，也叫**赫夫曼树（哈夫曼树）**

## 构建赫夫曼树

![](http://upyun.ishavanti.top/img/HuffmanTree.gif)

给定一组权值，构建赫夫曼树的步骤如下：

- 对数组排序
- 找出最小的两个节点权值
- 为这两个节点构建一个父节点，权值为这两个最小的权值相加
- 将这两个最小权值节点从数组移除，将其父节点添加到数组中
- 重复以上步骤

## 代码实现

**Node.class**

```java
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
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
```

**HuffmanTree.class**

```java
public class HuffmanTree {
    private Node root;

    public HuffmanTree(int[] arr) {
        this.root = this.createHuffmanTree(arr);
    }

    /**
     * 根据传入数组创建赫夫曼树
     */
    private Node createHuffmanTree(int[] arr) {
        // 先根据传入的数组元素，创建若干个节点
        Node[] nodes = new Node[arr.length];
        for (int i=0; i<arr.length; i++) {
            nodes[i] = new Node(arr[i]);
        }
        // 记录数组中剩余的节点
        int num = arr.length;
        while (num > 1) {
            // 当数组中的元素多于两个时，用两轮冒泡排序，将最小的两个节点放到数组最后
            for (int i = 0; i < 2 && num > 2; i++) {
                for (int j = 0; j < num-1; j++) {
                    if (nodes[j].getValue() < nodes[j + 1].getValue()) {
                        Node temp = nodes[j];
                        nodes[j] = nodes[j + 1];
                        nodes[j + 1] = temp;
                    }
                }
            }
            // 产生新的节点，为这两个节点的父节点，且权值为这两个节点之和
            Node parent = new Node(nodes[num - 2].getValue() + nodes[num-1].getValue());
            parent.setLeft(nodes[num - 2]);
            parent.setRight(nodes[num - 1]);
            // 将parent节点与剩余节点一起重新排序，重复以上操作
            nodes[num - 2] = parent;
            num--;
        }
        // num=1，数组中第0个元素为根节点
        return nodes[0];
    }

    public Node getRoot() {
        return root;
    }
}
```

## 赫夫曼编码

举个🌰：

假如我们要传输一句话：**can you can a can as a canner can can a can.**

如果采用定长编码，每个字符对应的ASCII码都采用8位的二进制表示，那么：

![](http://upyun.ishavanti.top/img/HuffmanCode.png)

传输的将是很长的一段二进制编码（原本是没有空格的，图中的空格只是为了显示方便）

采用**赫夫曼编码**：

![](http://upyun.ishavanti.top/img/HuffmanCode2.png)

首先是统计出每个字符出现的次数，然后构建一颗赫夫曼树（左路径为0，右路径为1），出现次数最多的字符距离根节点最近，出现次数最少的字符距离根节点最远。根据这个赫夫曼树的编码规则，出现次数多的字符采用较少的位数，能够有效节省传输内容。而且，由于每个字符都是叶子节点，它对应的编码都是唯一的，不会出现冲突。

## 数据压缩

步骤：

- 统计字符出现的次数
- 创建一颗赫夫曼树
- 创建一个赫夫曼编码表
- 编码


以下代码实现数据压缩，解压缩，文件压缩和文件解压：

**HuffmanCoding.class**

```java
package DataStructure.Tree.HuffmanTree.HuffmanCoding;

import java.io.*;
import java.util.*;

public class HuffmanCoding {
    // 原始byte数组
    private byte[] bytes;
    // 赫夫曼树的根节点
    private Node root;
    // 压缩后的byte数组
    private byte[] encodedBytes;
    // 保存编码表
    private Map<Byte, String> huffCodes = new HashMap<>();

    /**
     * 压缩byte数组
     */
    public HuffmanCoding(byte[] bytes) {
        this.bytes = bytes;
    }

    /**
     * 压缩文件
     * @param file 文件路径
     */
    public HuffmanCoding(String file) {
        try {
            // 创建一个输入流
            InputStream is = new FileInputStream(file);
            // 初始化bytes数组，和输入流指向的文件大小一样
            bytes = new byte[is.available()];
            // 读取文件内容
            is.read(bytes);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 进行赫夫曼压缩的方法
     * @return 压缩后的字节数组
     */
    public byte[] huffmanCoding() {
        if (this.encodedBytes != null) {
            return encodedBytes;
        }
        // 先统计每一个byte出现的次数，并存入一个集合中
        List<Node> nodes = getNodes(bytes);
        // 创建一颗赫夫曼树
        this.root = createHuffmanTree(nodes);
        // 创建一个赫夫曼编码表，保存在huffCodes中
        getCodes();
        // 编码
        zip();
        return this.encodedBytes;
    }

    /**
     * 输出到文件
     */
    public void out2file(String file) {
        try {
            byte[] bytes = huffmanCoding();
            // 输出流
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            // 把压缩后的byte数组写入文件
            oos.writeObject(bytes);
            // 把赫夫曼编码表写入文件
            oos.writeObject(this.huffCodes);
            oos.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解码文件
     * @param out 输出文件的路径
     */
    public void decodeFile(String file, String out) {
        try {
            // 读取文件数据
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            // 读取byte数组
            byte[] b = (byte[]) ois.readObject();
            // 读取赫夫曼编码表
            Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
            ois.close();
            is.close();
            // 解码
            byte[] bytes = huffmanDecoding(b, codes);
            // 创建一个输出流
            OutputStream os = new FileOutputStream(out);
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解码
     * @param bytes
     * @return
     */
    public byte[] huffmanDecoding(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        // 把byte数组转为一个二进制的字符串
        for (int i=0; i<bytes.length; i++) {
            byte b = bytes[i];
            // 最后一个数不用补0
            boolean flag = !(i == bytes.length - 1);
            sb.append(byte2bitStr(b, flag));
        }
        // 把字符串按照指定的赫夫曼编码进行解码
        // 把赫夫曼编码表的键值对进行调换
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        // 由于新的byte数组长度不确定，用一个list集合保存byte
        List<Byte> decodedList = new ArrayList<>();
        // 处理字符串
        for (int i=0; i<sb.length();) {
            int count = 1;
            while (true) {
                String key = sb.substring(i, i + count);
                Byte b = map.get(key);
                if (b != null) {
                    decodedList.add(b);
                    break;
                }
                count++;
            }
            i += count;
        }
        // 把集合转为数组
        byte[] decodedBytes = new byte[decodedList.size()];
        for (int i=0; i<decodedBytes.length; i++) {
            decodedBytes[i] = decodedList.get(i);
        }
        return decodedBytes;
    }

    /**
     * 将字节转为8位二进制的字符串
     * 对于负数，取最后8位，对于正数，前面几位要补0
     * @param flag 是否补0（最后一个数不用补0）
     */
    private String byte2bitStr( byte b, boolean flag) {
        int temp = b;
        if (flag) {
            // 按位或 256
            temp |= 256;
        }
        String s = Integer.toBinaryString(temp);
        if (flag) {
            return s.substring(s.length() - 8);
        }
        return s;
    }

    /**
     * 进行赫夫曼编码
     */
    private void zip() {
        StringBuilder sb = new StringBuilder();
        // 把需要压缩的byte数组处理成一个二进制的字符串
        for (byte b : this.bytes) {
            sb.append(this.huffCodes.get(b));
        }
        // 定义长度
        int len = (int)Math.ceil(sb.length() / 8.0);
        // 初始化encodedBytes
        encodedBytes = new byte[len];
        int index = 0;
        for (int i=0; i<sb.length(); i+=8) {
            String strByte;
            if (i+8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            byte byt = (byte) Integer.parseInt(strByte, 2);
            encodedBytes[index++] = byt;
        }
    }

    /**
     * 创建赫夫曼编码表
     * @return
     */
    private void getCodes() {
        if (this.root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        getCodes(this.root.getLeft(), "0", sb);
        getCodes(this.root.getRight(), "1", sb);
    }

    private void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.getData() == null) {
            getCodes(node.getLeft(), "0", sb2);
            getCodes(node.getRight(), "1", sb2);
        } else {
            huffCodes.put(node.getData(), sb2.toString());
        }
    }

    /**
     * 创建赫夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 排序
            Collections.sort(nodes);
            // 取出两个权值最低的二叉树
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            // 创建一棵新的二叉树
            Node parent = new Node(null, left.getWeight() + right.getWeight());
            // 把之前取出来的两棵二叉树设置为新创建的二叉树的子树
            parent.setLeft(left);
            parent.setRight(right);
            // 把之前取出来的两棵二叉树删除
            nodes.remove(left);
            nodes.remove(right);
            // 把新创建的二叉树放入集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 把byte数组转为node集合
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        // 统计每一个byte出现的次数
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count+1);
            }
            // 以上代码在1.8中的实现
            // 参数1是key值，参数2是新的value值，参数3是value更新的函数
            // 参数3的函数有两个参数，第一个参数为旧value值（如果key不存在则直接赋予新value值），第二个参数为新value值
            // counts.merge(b, 1, (a, a2) -> a + 1);
        }
        // 把每一个键值对转换为node对象
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public Node getRoot() {
        return root;
    }

    public Map<Byte, String> getHuffCodes() {
        return huffCodes;
    }
}
```

**TestHuffmanCoding.class**

```java
package DataStructure.Tree.HuffmanTree.HuffmanCoding;

import java.util.Arrays;

public class TestHuffmanCoding {
    public static void main(String[] args) {
        // {32=11, 97=11, 114=1, 99=7, 115=1, 117=1, 101=1, 121=1, 110=8, 111=1}
        String msg = "can you can a can as a can canner can a can";
        byte[] bytes = msg.getBytes();

        // 进行赫夫曼编码
        HuffmanCoding tree = new HuffmanCoding(bytes);
        byte[] encodedBytes = tree.huffmanCoding();
        System.out.println(Arrays.toString(tree.getBytes()));
        System.out.println(Arrays.toString(tree.huffmanDecoding(encodedBytes, tree.getHuffCodes())));
        System.out.println(new String(tree.huffmanDecoding(encodedBytes, tree.getHuffCodes())));

        // 测试文件压缩
        String path = "src/DataStructure/Tree/HuffmanTree/HuffmanCoding/";
        HuffmanCoding fileTree = new HuffmanCoding(path + "test.jpg");
        // 压缩后图片变大了？因为编码表内容也比较多？
        // 图片越复杂压缩率越低，越单一的图片压缩率越高
        fileTree.out2file(path + "encoded.jpg");
        System.out.println(fileTree.getBytes().length);
        System.out.println(fileTree.huffmanCoding().length);
        // 解压缩文件
        fileTree.decodeFile(path + "encoded.jpg", path + "decoded.jpg");
    }
}
```

# 二叉排序树/二叉查找树

**二叉排序树**也叫**二叉查找树**，**二叉搜索树**，**BST(Binary Search Tree)**

对于二叉树中的任何一个非叶子节点，要求左子节点权值比当前节点权值小，右子节点权值比当前节点权值大。

二叉排序树的优点是查找速度快，插入和删除类似链表，速度也比较快

![](http://upyun.ishavanti.top/img/BinarySearchTree.png)

## 添加节点

- 判断传入节点的值比当前节点的值大还是小
- 如果比当前节点小，判断左子节点是否为空，如果为空则将传入节点设置为左子节点；如果不为空，则继续往左子树遍历
- 如果比当前节点大，判断右子节点是否为空，如果为空则将传入节点设置为右子节点；如果不为空，则继续往右子树遍历

### 代码

**Node.class**

```java
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
     * 遍历结果由大到小
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
```

**BinarySearchTree.class**

```java
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
```

**TestBST.class**

```java
package DataStructure.Tree.BinarySearchTree;

public class TestBST {
    public static void main(String[] args) {
        int[] arr = new int[] {7, 3, 10, 12, 5, 1, 9};
        // 循环添加
        BinarySearchTree bst = new BinarySearchTree();
        for (int v : arr) {
            bst.addNode(new Node(v));
        }
        // 中序遍历（按从小到大的顺序输出）
        bst.middleShow();
    }
}
```

## 查找节点

- 先比较当前节点值与目标节点值
- 相等，直接返回当前节点
- 大于目标节点值，如果左子节点不为空，往左子树递归；为空则返回空
- 小于目标节点值，如果右子节点不为空，往左子树递归；为空则返回空

### 代码

**Node.class**

```java
package DataStructure.Tree.BinarySearchTree;

public class Node {
		// ......

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
  
		// ......
}
```

**BinarySearchTree.class**

```java
package DataStructure.Tree.BinarySearchTree;

public class BinarySearchTree {
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
}
```

**TestBST.class**

```java
package DataStructure.Tree.BinarySearchTree;

public class TestBST {
    public static void main(String[] args) {
        int[] arr = new int[] {7, 3, 10, 12, 5, 1, 9};
        // 循环添加
        BinarySearchTree bst = new BinarySearchTree();
        for (int v : arr) {
            bst.addNode(new Node(v));
        }
        // 中序遍历（按从小到大的顺序输出）
        bst.middleShow();
      
      	System.out.println("============");
        // 测试查找节点
        System.out.println(bst.search(3));
    }
}
```

## 删除节点

删除节点分为3种情况：

1. 要删除的节点为叶子节点：
   - 找到目标节点的父节点
   - 判断目标节点是其父节点的左子节点或右子节点
   - 将父节点的左子节点或右子节点设为null
2. 要删除的节点有两个子节点：
   - 找到目标节点的父节点
   - 找到目标节点的后继节点，即右子树中最小的节点
   - 删除后继节点，并将目标节点替换为后继节点的值
3. 要删除的节点只有一个左子节点或右子节点：
   - 找到目标节点的父节点
   - 找到目标节点的子节点
   - 判断目标节点是其父节点的左子节点或右子节点
   - 将父节点的左子节点或右子节点设为其子节点

### 代码

**Node.class**

```java
package DataStructure.Tree.BinarySearchTree;

public class Node {
    // ......

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
  	
  	// ......
}
```

**BinarySearchTree.class**

```java
package DataStructure.Tree.BinarySearchTree;

public class BinarySearchTree {
    // ......
  	
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
  
  	// .....
}
```

**TestBST.class**

```java
package DataStructure.Tree.BinarySearchTree;

public class TestBST {
    public static void main(String[] args) {
        int[] arr = new int[] {7, 3, 10, 12, 5, 1, 9};
        // 循环添加
        BinarySearchTree bst = new BinarySearchTree();
        for (int v : arr) {
            bst.addNode(new Node(v));
        }
        // 中序遍历（按从小到大的顺序输出）
        bst.middleShow();

        System.out.println("============");
        // 测试查找父节点
        System.out.println(bst.searchParent(1).getValue());

        System.out.println("============");
        // 测试删除叶子节点
        bst.delete(5);
        bst.middleShow();

        System.out.println("============");
        // 测试删除只有一个子节点的节点
        bst.delete(3);
        bst.middleShow();

        System.out.println("============");
        // 测试删除有两个子节点的节点
        bst.delete(7);
        bst.middleShow();
    }
}
```

# 平衡二叉树（AVL树）

## 二叉排序树的缺点

对于一个有序的序列，如**[1, 2, 3, 4, 5]**，构造出的二叉排序树

![](http://upyun.ishavanti.top/img/AVLTree1.png)

这样的二叉排序树和普通的单链表并没有太大区别，性能反而会更差一些，查找速度也并没有提升。

## 平衡二叉搜索树

> 平衡二叉搜索树（Self-balancing binary search tree）又被称为AVL树（有别于AVL算法），且具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
>
> 平衡二叉树的常用实现方法有[红黑树](https://baike.baidu.com/item/红黑树/2413209)、[AVL](https://baike.baidu.com/item/AVL/7543015)、[替罪羊树](https://baike.baidu.com/item/替罪羊树/13859070)、[Treap](https://baike.baidu.com/item/Treap)、[伸展树](https://baike.baidu.com/item/伸展树/7003945)等。 
>
> 最小二叉平衡树的节点总数的公式如下 F(n)=F(n-1)+F(n-2)+1 这个类似于一个递归的[数列](https://baike.baidu.com/item/数列/731531)，可以参考Fibonacci(斐波那契)数列，1是根节点，F(n-1)是左子树的节点数量，F(n-2)是右子树的节点数量。

## 构建平衡二叉树

![](http://upyun.ishavanti.top/img/AVLTree.gif)

构建平衡二叉树有几种情况：单旋转（右旋转与左旋转），双旋转（先左后右，先右后左）

- 单旋转：

  - 右旋转：

    1. 创建一个新节点，值等于当前节点的值
    2. 把新节点的右子树设置为当前节点的右子树
    3. 把新节点的左子树设置为当前节点的左节点的右子树
    4. 把当前节点的值设置为左子节点的值
    5. 把当前节点的左子树设置为左子节点的左子树
    6. 把当前节点的右子树设置为新节点

    ![](http://upyun.ishavanti.top/img/AVLTree2.png)

  - 左旋转与右旋转的操作正好相反，可类推

- 双旋转

  - 先左后右

  ![](http://upyun.ishavanti.top/img/AVLTree3.png)

  - 先右后左 与 先走后右的操作正好相反，可类推

## 代码实现

**Node.java**

```java
package DataStructure.Tree.AVLTree;

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
        // 检查是否平衡
        int leftHeight = this.left == null ? 0 : this.left.height();
        int rightHeight = this.right == null ? 0 : this.right.height();
        if (leftHeight - rightHeight > 1) {
            // 左子树的左右子树高度
            int leftLeftHeight = this.left.left == null ? 0 : this.left.left.height();
            int leftRightHeight = this.left.right == null ? 0 : this.left.right.height();
            // 如果左子树的左子树高度小于右子树高度，属于双旋转情况
            if (leftLeftHeight < leftRightHeight) {
                // 需要先对左子树进行左旋转
                this.left.leftRotate();
            }
            // 进行右旋转
            rightRotate();
        } else if (rightHeight - leftHeight > 1){
            // 右子树的左右子树高度
            int rightLeftHeight = this.right.left == null ? 0 : this.right.left.height();
            int rightRightHeight = this.right.right == null ? 0 : this.right.right.height();
            // 双旋转情况
            if (rightLeftHeight > rightRightHeight) {
                // 需要先对右子树进行右旋转
                this.right.rightRotate();
            }
            // 进行左旋转
            leftRotate();
        }
    }

    /**
     * 右旋转
     */
    private void rightRotate() {
        // 1. 创建一个新节点，值等于当前节点的值
        Node newRight = new Node(this.value);
        // 2. 把新节点的右子树设置为当前节点的右子树
        newRight.right = this.right;
        // 3. 把新节点的左子树设置为当前节点的左节点的右子树
        newRight.left = this.left.right;
        // 4. 把当前节点的值设置为左子节点的值
        this.value = this.left.value;
        // 5. 把当前节点的左子树设置为左子节点的左子树
        this.left = this.left.left;
        // 6. 把当前节点的右子树设置为新节点
        this.right = newRight;
    }

    /**
     * 左旋转
     */
    private void leftRotate() {
        // 1. 创建一个新节点，值等于当前节点的值
        Node newLeft = new Node(this.value);
        // 2. 把新节点的右子树设置为当前节点的右子树
        newLeft.left = this.left;
        // 3. 把新节点的左子树设置为当前节点的左节点的右子树
        newLeft.right = this.right.left;
        // 4. 把当前节点的值设置为左子节点的值
        this.value = this.right.value;
        // 5. 把当前节点的左子树设置为左子节点的左子树
        this.right = this.right.right;
        // 6. 把当前节点的右子树设置为新节点
        this.left = newLeft;
    }

    /**
     * 返回当前节点的高度
     * @return
     */
    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
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
```

**AVLTree.java**

```java
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
```

**TestAVLTree.java**

```java
package DataStructure.Tree.AVLTree;

public class TestAVLTree {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        // 创建一颗平衡二叉树
        AVLTree avlTree = new AVLTree();
        // 添加节点
        for (int v : arr) {
            avlTree.addNode(new Node(v));
        }
        // 查看高度
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().getLeft().height());
        System.out.println(avlTree.getRoot().getRight().height());
    }
}
```

# 红黑树

**红黑树**是一种二叉查找树，但在每个节点增加一个存储位表示节点的颜色，可以是红或黑（非红即黑）。通过对任何一条从根到叶子的路径上各个节点着色的方式的限制，红黑树确保没有一条路径会比其它路径长出两倍，因此，红黑树是一种弱平衡二叉树（由于是弱平衡，可以看到，在相同的节点情况下，AVL树的高度低于红黑树），相对于要求严格的AVL树来说，它的旋转次数少，所以对于搜索，插入，删除操作较多的情况下，我们就用红黑树。

与平衡二叉树比较：

- 红黑树，旋转次数少，高度较高，适用于搜索少，插入和删除操作较多的情况
- AVL树，旋转次数多，高度较低，适用于搜索多，插入和删除操作较少的情况

![](http://upyun.ishavanti.top/img/RedBlackTree.jpg)

**红-黑规则：**

- 每个节点不是红色就是黑色的

- 根节点总是黑色的

- 如果节点是红色的，则它的子节点必须是黑色的（反之不一定）,(也就是从每个叶子到根的所有路径上不能有两个连续的红色节点)

- 从根节点到叶节点或空子节点的每条路径，必须包含相同数目的黑色节点（即相同的黑色高度）。

红黑树的修正方式：变色，左旋和右旋

**左旋转**

![](http://upyun.ishavanti.top/img/LeftRotate.gif)

**右旋转**

![](http://upyun.ishavanti.top/img/RightRotate.gif)

## 左旋和右旋

![](http://upyun.ishavanti.top/img/RedBlackTreeRotate.png)

## 构建红黑树

> 参考：[https://www.cnblogs.com/ysocean/p/8004211.html](https://www.cnblogs.com/ysocean/p/8004211.html)

- 默认插入节点为红色（因为红黑树中黑节点至少是红节点的两倍，因此插入节点的父节点为黑色的概率较大，而此时并不需要作任何调整，因此效率较高）
- 首次插入时，直接将根节点变黑即可
- 如果插入的节点的父节点是黑色，直接插入即可
- 如果插入的节点的父节点是红色，那么此时违背了红黑树的规则，分为以下几种情况：
  - 插入节点的父节点和叔叔节点（祖父节点的另一个子节点）都是红色
  - 插入节点的父节点是红色，叔叔节点是黑色，且插入节点为父节点的右子节点
  - 插入节点的父节点是红色，叔叔节点是黑色，且插入节点为父节点的左子节点

对于情况1：**插入节点的父节点和其叔叔节点（祖父节点的另一个子节点）均为红色。**

![](http://upyun.ishavanti.top/img/RedBlackTree1.png)

此时，肯定存在祖父节点，但是不知道父节点是其左子节点还是右子节点，但是由于对称性，我们只要讨论出一边的情况，另一种情况自然也与之对应。这里考虑父节点是其祖父节点的左子节点的情况。

对于这种情况，我们要做的操作有：**将当前节点(4) 的父节点(5) 和叔叔节点(8) 涂黑，将祖父节点(7)涂红。再将当前节点指向其祖父节点**，再次从新的当前节点开始算法（具体看下面的步骤）。这样就变成情况2了。

![](http://upyun.ishavanti.top/img/RedBlackTree2.png)

对于情况2：**插入节点的父节点是红色的，叔叔节点是黑色的，且插入节点是其父节点的右子节点**。我们要做的操作有：**以当前节点(7)的父节点(2)为支点做左旋操作，然后将当前节点指向节点(2)**。完成后就变成情况3了。

![](http://upyun.ishavanti.top/img/RedBlackTree3.png)

对于情况3：**插入节点的父节点是红色，叔叔节点是黑色，且插入节点是其父节点的左子节点**。我们要做的操作有：**将当前节点的父节点(7)涂黑，将祖父节点(11)涂红，以祖父节点为支点做右旋操作。将根节点涂黑。**至此，插入操作完成，整个红-黑树重新恢复了平衡！

![](http://upyun.ishavanti.top/img/RedBlackTree4.png)

## 代码实现

**Node.java**

```java
package DataStructure.Tree.RedBlackTree;

public class Node {

    public enum Color {
        RED, BLACK
    }

    private int value;
    // 默认节点颜色为红色
    private Color color = Color.RED;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 中序遍历
     */
    public void InOrderTraversal() {
        if (this.left != null) {
            this.left.InOrderTraversal();
        }
        System.out.print(this.value + " ");
        if (this.right != null) {
            this.right.InOrderTraversal();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
```

**RedBlackTree.java**

```java
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
```

**TestRedBlackTree.java**

```java
package DataStructure.Tree.RedBlackTree;

import DataStructure.Sort.ArrayUtil;

public class TestRedBlackTree {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(30, 0, 500);
        RedBlackTree tree = new RedBlackTree();
        for (int v : arr) {
            System.out.print(v+" ");
            tree.insert(new Node(v));
        }
        System.out.println();
        tree.InOrderTraversal();
    }
}
```

# 多路查找树

**多路查找树(muitl-way search tree)**，其每一个节点的孩子数可以多于两个，且每一个节点处可以存储多个元素。

主要有4种特殊形式：[2-3树](#2-3树)，[2-3-4树](#2-3-4树)，[B树](#B树)，[B+树](#B+树)

**2-3树**和**2-3-4树**都是**B树**的一种特例

## 2-3树



## 2-3-4树



## B树

一棵m阶B树(balanced tree of order m)是一棵平衡的m路搜索树。它或者是空树，或者是满足下列性质的树：

1、根结点至少有两个子女；

2、每个非根节点所包含的关键字个数 j 满足：⌈m/2⌉ - 1 <= j <= m - 1；

3、除根结点以外的所有结点（不包括叶子结点）的度数正好是关键字总数加1，故**内部子树**个数 k 满足：⌈m/2⌉ <= k <= m ；（⌈⌉是向上取整）

4、所有的叶子结点都位于同一层。

## B+树

