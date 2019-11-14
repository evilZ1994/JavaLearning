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
