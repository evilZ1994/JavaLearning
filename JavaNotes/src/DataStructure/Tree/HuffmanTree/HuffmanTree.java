package DataStructure.Tree.HuffmanTree;

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
